package ExamPreparation.easterRaces.core;

import ExamPreparation.easterRaces.core.interfaces.Controller;
import ExamPreparation.easterRaces.entities.cars.Car;
import ExamPreparation.easterRaces.entities.cars.MuscleCar;
import ExamPreparation.easterRaces.entities.cars.SportsCar;
import ExamPreparation.easterRaces.entities.drivers.Driver;
import ExamPreparation.easterRaces.entities.drivers.DriverImpl;
import ExamPreparation.easterRaces.entities.racers.Race;
import ExamPreparation.easterRaces.entities.racers.RaceImpl;
import ExamPreparation.easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static ExamPreparation.easterRaces.common.ExceptionMessages.*;
import static ExamPreparation.easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverData = new DriverImpl(driver);
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        driverRepository.add(driverData);

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        carRepository.add(car);

        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Race race = raceRepository.getByName(raceName);

        List<Driver> drivers = race.getDrivers().stream().sorted((a, b) ->
                Double.compare(b.getCar().calculateRacePoints(raceRepository.getByName(raceName).getLaps()),
                        a.getCar().calculateRacePoints(raceRepository.getByName(raceName).getLaps()))).
                collect(Collectors.toList());

        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION, drivers.get(0).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, drivers.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, drivers.get(2).getName(), raceName));

        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
