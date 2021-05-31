package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishes;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fishes = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        int sum = 0;
        for(Decoration decoration : decorations){
            sum+=decoration.getComfort();
        }

        return sum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if(capacity > 0){
            this.fishes.add(fish);
            this.capacity--;
        }else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        fishes.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for(Fish fish : fishes){
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", getName(), getClass().getSimpleName())).
                append(System.lineSeparator());

        if(fishes.isEmpty()){
            sb.append("Fish: none").append(System.lineSeparator());
        }else{
            sb.append("Fish: ");
        }

        if(!fishes.isEmpty()) {
            for (Fish fish : fishes) {
                sb.append(fish.getName()).append(" ");
            }
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Decorations: %s", decorations.size())).
                append(System.lineSeparator());
        sb.append(String.format("Comfort: %s", calculateComfort())).
                append(System.lineSeparator());

        return sb.toString().trim();
    }

//    StringBuilder fish = new StringBuilder();
//
//        if(this.fish.size() > 0){
//        for (Fish fish1 : this.fish) {
//            fish.append(fish1.getName()).append(" ");
//        }
//        fish = new StringBuilder(fish.toString().trim());
//    }
//        if(fish.toString().isEmpty()){
//        return String.format("%s (%s):\n" +
//                "Fish: none\n" +
//                "Decorations: %s\n" +
//                "Comfort: %s", this.name, this.decorations.size(), this.calculateComfort());
//    }
//
//        return String.format("%s (%s):\n" +
//                "Fish: %s\n" +
//                "Decorations: %s\n" +
//                "Comfort: %s", this.name, this.getClass().getSimpleName(), fish, this.decorations.size(), this.calculateComfort());

    @Override
    public Collection<Fish> getFish() {
        return this.fishes;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
