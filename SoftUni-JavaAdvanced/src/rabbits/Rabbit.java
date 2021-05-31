package rabbits;

public class Rabbit {

    private String name;
    private String species;
    private boolean isAvailable = true;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setAvailable(){
        this.setAvailable(false);
    }

    @Override
    public String toString(){
        return String.format("Rabbit (%s): %s", this.species, this.name);
    }
}
