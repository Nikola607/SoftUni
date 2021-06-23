package ExamPreparation.CounterStriker.repositories;

import ExamPreparation.CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static ExamPreparation.CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Player model) {
        if(model == null){
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        if(!models.contains(model)){
            return false;
        }
        models.remove(model);
        return true;
    }

    @Override
    public Player findByName(String name) {
        return models.stream().filter(e -> e.getUsername().equals(name)).
                findFirst().orElse(null);
    }
}
