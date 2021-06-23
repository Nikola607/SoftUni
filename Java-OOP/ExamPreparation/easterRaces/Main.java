package ExamPreparation.easterRaces;

import ExamPreparation.easterRaces.core.ControllerImpl;
import ExamPreparation.easterRaces.core.EngineImpl;
import ExamPreparation.easterRaces.core.interfaces.Controller;
import ExamPreparation.easterRaces.entities.cars.Car;
import ExamPreparation.easterRaces.entities.drivers.Driver;
import ExamPreparation.easterRaces.entities.racers.Race;
import ExamPreparation.easterRaces.io.ConsoleReader;
import ExamPreparation.easterRaces.io.ConsoleWriter;
import ExamPreparation.easterRaces.repositories.CarRepository;
import ExamPreparation.easterRaces.repositories.DriverRepository;
import ExamPreparation.easterRaces.repositories.RaceRepository;
import ExamPreparation.easterRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args)  {
        Repository<Car> motorcycleRepository = new CarRepository(); // TODO: new CarRepository<>();
        Repository<Race> raceRepository = new RaceRepository(); // TODO: new RaceRepository<>();
        Repository<Driver> riderRepository = new DriverRepository(); // TODO: new DriverRepository<>();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository); // TODO: new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
