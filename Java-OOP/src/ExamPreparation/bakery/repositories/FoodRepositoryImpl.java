package ExamPreparation.bakery.repositories;

import ExamPreparation.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation.bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private final Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return models.stream().filter(e -> e.getName().equals(name)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        models.add(bakedFood);
    }
}
