package DefiningClasses.PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split("\\s+");
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        while (!data[0].equals("Tournament")) {
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            trainerMap.putIfAbsent(trainerName, new Trainer());

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.get(trainerName).getPokemonCollection().add(pokemon);

            data = scan.nextLine().split("\\s+");
        }

        String elementNeeded = scan.nextLine();
        while (!elementNeeded.equals("End")) {
            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {

                if (trainer.getValue().pokemonSizeCheck() > 0) {
                    boolean havePokemon = false;

                    for (Pokemon pokemon : trainer.getValue().getPokemonCollection()) {

                        if (pokemon.getElement().equals(elementNeeded)) {
                            havePokemon = true;
                            trainer.getValue().addBadge();
                            break;
                        }
                    }
                    if(!havePokemon){
                        trainer.getValue().missingPokemon();
                    }
                }
            }
            elementNeeded = scan.nextLine();
        }

        trainerMap.entrySet().stream().
                sorted((a, b) -> Integer.compare(b.getValue().getBadges(), a.getValue().getBadges())).
                forEach(e -> System.out.printf("%s %s %s\n", e.getKey(), e.getValue().getBadges(), e.getValue().pokemonSizeCheck()));
    }
}
