package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decoration;
    private Collection<Aquarium> aquariumCollection;

    public ControllerImpl() {
        this.decoration = new DecorationRepository();
        this.aquariumCollection = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariumCollection.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquarium.getClass().getSimpleName());
    }

    @Override
    public String addDecoration(String type) {
        Decoration decorationType = null;

        switch (type) {
            case "Ornament":
                decorationType = new Ornament();
                break;
            case "Plant":
                decorationType = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        decoration.add(decorationType);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, decorationType.getClass().getSimpleName());
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        if (decoration.findByType(decorationType) == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium neededAquarium = aquariumCollection.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().get();
        neededAquarium.addDecoration(decoration.findByType(decorationType));

        decoration.remove(decoration.findByType(decorationType));
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium current = null;
        for (Aquarium aquarium : aquariumCollection) {
            if(aquarium.getName().equals(aquariumName)){
                current = aquarium;
                break;
            }
        }

        switch (fishType){
            case "FreshwaterFish":
                if (current != null && current.getClass().getSimpleName().equals("FreshwaterAquarium")) {
                    current.addFish(new FreshwaterFish(fishName, fishSpecies, price));
                }else {
                    return "Water not suitable.";
                }
                break;

            case "SaltwaterFish":
                if (current != null && current.getClass().getSimpleName().equals("SaltwaterAquarium")) {
                    current.addFish(new FreshwaterFish(fishName, fishSpecies, price));
                }else {
                    return "Water not suitable.";
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid fish type.");
        }
        return String.format("Successfully added %s to %s.", fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium neededAquarium = aquariumCollection.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().get();
        neededAquarium.feed();

        int fedFish = neededAquarium.getFish().size();
        return String.format(FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium neededAquarium = aquariumCollection.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().get();
        double sum = 0;

        for (Decoration decoration : neededAquarium.getDecorations()) {
            sum += decoration.getPrice();
        }

        for (Fish fish : neededAquarium.getFish()) {
            sum += fish.getPrice();
        }
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariumCollection) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
