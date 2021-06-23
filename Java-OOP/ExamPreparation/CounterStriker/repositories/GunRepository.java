package ExamPreparation.CounterStriker.repositories;

import ExamPreparation.CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static ExamPreparation.CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        if (!models.contains(model)) {
            return false;
        }
        models.remove(model);
        return true;
    }

    @Override
    public Gun findByName(String name) {
        return models.stream().filter(e -> e.getName().equals(name)).
                findFirst().orElse(null);
    }
}
