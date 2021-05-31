package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> data;
    private List<Player> kickedPlayers;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
        this.kickedPlayers = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(this.capacity > 0){
            data.add(player);
            capacity--;
        }
    }

    public boolean removePlayer(String name){
        return data.removeIf(e -> e.getName().equals(name));
    }

    public void promotePlayer(String name){
        for(Player e : data){
            if(e.getName().equals(name) && !e.getRank().equals("Member")){
                e.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name){
        for(Player e : data){
            if(e.getName().equals(name) && !e.getRank().equals("Trial")){
                e.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        Player[] removed = data.stream().
                filter(e -> e.getClazz().equals(clazz)).
                toArray(Player[]::new);
        for(Player e : removed){
            data.remove(e);
        }
        return removed;
    }

    public int count() {
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();

        System.out.println();
        sb.append("Players in the guild " + this.name + ":").append(System.lineSeparator());
        for(Player e : data){
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
