package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean removeRabbit(String name){
        return data.removeIf(e -> e.getName().equals(name));
    }

    public void removeSpecies(String species){
        data.removeIf(e -> e.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name){
        for(Rabbit e : data){
            if(e.getName().equals(name)){
                e.setAvailable(false);
                return e;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> sold = new ArrayList<>();
        for(Rabbit e : data){
            if(e.getSpecies().equals(species)){
                e.setAvailable(false);
                sold.add(e);
            }
        }
        return sold;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();

        sb.append("Rabbits available at " + this.name + ":").append(System.lineSeparator());
        for(Rabbit e : data){
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public void add(Rabbit rabbit){
        if (this.capacity > this.data.size()){
            this.data.add(rabbit);
        }
    }
}
