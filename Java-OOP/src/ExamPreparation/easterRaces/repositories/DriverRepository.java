package ExamPreparation.easterRaces.repositories;

import ExamPreparation.easterRaces.entities.drivers.Driver;
import ExamPreparation.easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverRepository implements Repository<Driver> {
    private Map<String, Driver> models;

    public DriverRepository(){
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Driver model) {
        models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Driver model) {
        Driver driver = models.remove(model);
        return driver != null;
    }
}
