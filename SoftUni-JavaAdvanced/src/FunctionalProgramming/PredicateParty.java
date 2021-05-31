package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    static List<String> quests = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        quests = Arrays.stream(scan.nextLine().split("\\s+")).
                collect(Collectors.toList());
        String[] commands = scan.nextLine().split("\\s+");

        while (!commands[0].equals("Party!")) {
            String criteria = commands[1];
            String symbols = commands[2];

            switch (commands[0]) {
                case "Remove":
                    remove(getPredicates(criteria, symbols));
                    break;
                case "Double":
                    add(getPredicates(criteria, symbols));
                    break;
            }
            commands = scan.nextLine().split("\\s+");
        }
        if(quests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(quests);
            System.out.print(quests.toString().replaceAll("[\\[\\]]", ""));
            System.out.print(" are going to the party!");
        }
    }

    public static void remove(Predicate<String> predicate) {
        quests.removeIf(predicate);
    }

    public static void add(Predicate<String> predicate){
        List<String> questsToAdd = new ArrayList<>();
        quests.stream().filter(predicate).forEach(questsToAdd::add);

        quests.addAll(questsToAdd);
    }

    private static Predicate<String> getPredicates(String criteria, String symbols) {
        Predicate<String> predicate = null;

        if (criteria.equals("StartsWith")) {
            predicate = name -> name.startsWith(symbols);
        } else if (criteria.equals("EndsWith")) {
            predicate = name -> name.endsWith(symbols);
        } else {
            predicate = name -> name.length() == Integer.parseInt(symbols);
        }
        return predicate;
    }
}
