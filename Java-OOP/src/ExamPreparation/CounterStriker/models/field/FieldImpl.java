package ExamPreparation.CounterStriker.models.field;

import ExamPreparation.CounterStriker.models.players.CounterTerrorist;
import ExamPreparation.CounterStriker.models.players.Player;
import ExamPreparation.CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static ExamPreparation.CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static ExamPreparation.CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field{

    @Override
    public String start(Collection<Player> players) {
        String winner = "";

        List<Player> counterTerrorists = players.stream().filter(e -> e instanceof CounterTerrorist).
                collect(Collectors.toList());

        List<Player> terrorists = players.stream().filter(e -> e instanceof Terrorist).
                collect(Collectors.toList());

        while (counterTerrorists.stream().anyMatch(Player::isAlive) && terrorists.stream().anyMatch(Player::isAlive)){

            //Terrorists attack first:
            for(Player attacker : counterTerrorists){
                if(attacker.isAlive()) {
                    for (Player victim : terrorists) {
                        if (victim.isAlive()) {
                            int damage = attacker.getGun().fire();
                            victim.takeDamage(damage);
                        }
                    }
                }
            }

            //CounterTerrorists attack second:
            for(Player attacker : terrorists) {
                if (attacker.isAlive()) {
                    for (Player victim : counterTerrorists) {
                        if (victim.isAlive()) {
                            int damage = attacker.getGun().fire();
                            victim.takeDamage(damage);
                        }
                    }
                }
            }
        }
        if(counterTerrorists.stream().noneMatch(Player::isAlive)){
            winner = TERRORIST_WINS;
        }else{
            winner = COUNTER_TERRORIST_WINS;
        }

        return winner;
    }
}
