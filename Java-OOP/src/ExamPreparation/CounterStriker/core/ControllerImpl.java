package ExamPreparation.CounterStriker.core;

import ExamPreparation.CounterStriker.models.field.Field;
import ExamPreparation.CounterStriker.models.field.FieldImpl;
import ExamPreparation.CounterStriker.models.guns.Gun;
import ExamPreparation.CounterStriker.models.guns.Pistol;
import ExamPreparation.CounterStriker.models.guns.Rifle;
import ExamPreparation.CounterStriker.models.players.CounterTerrorist;
import ExamPreparation.CounterStriker.models.players.Player;
import ExamPreparation.CounterStriker.models.players.Terrorist;
import ExamPreparation.CounterStriker.repositories.GunRepository;
import ExamPreparation.CounterStriker.repositories.PlayerRepository;

import static ExamPreparation.CounterStriker.common.ExceptionMessages.*;
import static ExamPreparation.CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller{
    private GunRepository gunRepository;
    private PlayerRepository playerRepository;
    private Field field;

    public ControllerImpl(){
        this.gunRepository = new GunRepository();
        this.playerRepository = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun = null;

        switch (type){
            case"Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case"Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        gunRepository.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player = null;

        if(gunRepository.findByName(gunName) == null){
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        switch (type){
            case"Terrorist":
                player = new Terrorist(username, health, armor, gunRepository.findByName(gunName));
                break;
            case"CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gunRepository.findByName(gunName));
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        playerRepository.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(playerRepository.getModels());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        playerRepository.getModels().stream().sorted((a, b) -> {
            int sort = a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName());
            if(sort == 0){
                sort = Integer.compare(b.getHealth(), a.getHealth());

                if(sort == 0){
                    sort = a.getUsername().compareTo(b.getUsername());
                }
            }
            return sort;
        }).forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
