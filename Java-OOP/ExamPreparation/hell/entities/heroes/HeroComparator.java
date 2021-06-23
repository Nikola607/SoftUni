package ExamPreparation.hell.entities.heroes;

import ExamPreparation.hell.interfaces.Hero;

import java.util.Comparator;

public class HeroComparator implements Comparator<Hero> {
    @Override
    public int compare(Hero o1, Hero o2) {
        long firstSum = o1.getStrength() + o1.getAgility() + o1.getIntelligence();
        long secondSum = o2.getStrength() + o2.getAgility() + o2.getIntelligence();

        if(firstSum > secondSum){
            return -1;
        }
        if(firstSum < secondSum){
            return 1;
        }

        firstSum = o1.getHitPoints() + o1.getDamage();
        secondSum = o2.getHitPoints() + o2.getDamage();

        return Long.compare(firstSum, secondSum);
    }
}
