package ExamPreparation.easterRaces.entities.drivers;

import ExamPreparation.easterRaces.entities.cars.Car;

import static ExamPreparation.easterRaces.common.ExceptionMessages.CAR_INVALID;
import static ExamPreparation.easterRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        this.setCanParticipate(false);
    }

    public void setName(String name) {
        if (name == null || name.length() < 5 ||
                name.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    public void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        if (car != null) {
            setCanParticipate(true);
        }
        return canParticipate;
    }
}
