package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonCollection;

    public Trainer() {
        this.badges = 0;
        this.pokemonCollection = new ArrayList<>();
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void addBadge(){
        this.badges++;
    }

    public int pokemonSizeCheck(){
        return this.pokemonCollection.size();
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);


    public void missingPokemon(){
        this.pokemonCollection = this.pokemonCollection.
                stream().
                map(damagePokemon).
                filter(pokemon -> pokemon.getHealth() > 10).
                collect(Collectors.toList());
    }
}
