package ExamPreparation.CounterStriker.models.players;

import ExamPreparation.CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl{
    public CounterTerrorist(String username, int health, int armour, Gun gun) {
        super(username, health, armour, gun);
    }
}
