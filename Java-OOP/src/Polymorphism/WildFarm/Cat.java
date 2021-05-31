package Polymorphism.WildFarm;

public class Cat extends Felime{
    private String breed;
    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound(){
        System.out.println("Meowwww");
    }

    @Override
    public String toString(){
        return String.format("%s[%s, %s, %s, %s, %d]", getClass().getSimpleName(), getName(), getBreed(),
                format().format(getWeight()), getLivingRegion(), getFoodEaten());
    }
}
