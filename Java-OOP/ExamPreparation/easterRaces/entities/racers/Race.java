package ExamPreparation.easterRaces.entities.racers;

import ExamPreparation.easterRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
