package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(capacity>0){
            this.data.add(pet);
            capacity--;
        }
    }

    public boolean remove(String petName){
        return data.removeIf(e -> e.getName().equals(petName));
    }

    public Pet getPet(String name, String owner){

        for(Pet e : data){
            if(e.getName().equals(name) && e.getOwner().equals(owner)){
                return e;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        Pet pet = null;

        for(Pet e : data){
            if(pet == null || pet.getAge() < e.getAge()){
                pet = e;
            }
        }
        return pet;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<data.size(); i++){
            sb.append(data.get(i).getName());
            sb.append(" ");
            sb.append(data.get(i).getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
