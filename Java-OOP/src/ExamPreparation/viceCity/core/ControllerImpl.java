package ExamPreparation.viceCity.core;

import ExamPreparation.viceCity.core.interfaces.Controller;
import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.models.guns.Pistol;
import ExamPreparation.viceCity.models.guns.Rifle;
import ExamPreparation.viceCity.models.neighbourhood.GangNeighbourhood;
import ExamPreparation.viceCity.models.neighbourhood.Neighbourhood;
import ExamPreparation.viceCity.models.players.CivilPlayer;
import ExamPreparation.viceCity.models.players.MainPlayer;
import ExamPreparation.viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ExamPreparation.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private ArrayDeque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.poll();

        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        if (!players.containsKey(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        players.get(name).getGunRepository().add(gun);

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, players.values());

        if (mainPlayer.getLifePoints() == 100 && players.values().stream()
                .allMatch(e -> e.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }
        List<Player> deadPlayers = players.values().stream().
                filter(e -> !e.isAlive()).collect(Collectors.toList());

        StringBuilder out = new StringBuilder(FIGHT_HAPPENED);
        out.append(System.lineSeparator()).
                append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).
                append(System.lineSeparator()).
                append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size())).
                append(System.lineSeparator()).
                append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.size() - deadPlayers.size()));

        for (Player player : deadPlayers) {
            deadPlayers.remove(player.getName());
        }

        return out.toString().trim();
    }
}
