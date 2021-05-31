package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private double weight;
    private String livingRegion;
    private Integer foodEaten;

    public Animal(String name, String type, double weight, String livingRegion) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.livingRegion = livingRegion;
        foodEaten = 0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();

    public void eat(Food food){
        foodEaten+=food.getQuantity();
    }
    protected DecimalFormat format(){
        return new DecimalFormat("##.##");
    }

    @Override
    public String toString(){
        return String.format("%s[%s, %s, %s, %d]", this.type, this.name, format().format(this.weight), this.livingRegion, foodEaten);
    }
}
