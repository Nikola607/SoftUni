package guild;

public class Player {

    private String name;
    private String clazz;
    private String rank = "Trial";
    private String description = "n/a";

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Player " + this.name + ": " + this.clazz).append(System.lineSeparator());
        sb.append("Rank: " + this.rank).append(System.lineSeparator());
        sb.append("Description: " + this.description).append(System.lineSeparator());

        return sb.toString().trim();
    }
}