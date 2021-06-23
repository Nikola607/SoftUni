package ExamPreparation.easterRaces.repositories;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import ExamPreparation.easterRaces.entities.cars.Car;
import ExamPreparation.easterRaces.repositories.interfaces.Repository;

public class CarRepository implements Repository<Car> {
    private final Map<String, Car> models;

    public CarRepository(){
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car model) {
        models.putIfAbsent(model.getModel(), model);
    }

    @Override
    public boolean remove(Car model) {
        Car car = models.remove(model);
        return car !=null;
    }
}
