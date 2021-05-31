package ExamPreparation.hell.entities.items;

import ExamPreparation.hell.interfaces.Item;

public class Items implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    public Items(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrengthBonus() {
        return strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return damageBonus;
    }

    public String toString(){
        return String.format("###Item: %s\n" +
                        "###+%d Strength\n" +
                        "###+%d Agility\n" +
                        "###+%d Intelligence\n" +
                        "###+%d HitPoints\n" +
                        "###+%d Damage",
                this.getName(),this.strengthBonus,this.agilityBonus,
                this.intelligenceBonus,this.hitPointsBonus,this.damageBonus);
    }
}
