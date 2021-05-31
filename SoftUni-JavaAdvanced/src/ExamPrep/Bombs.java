package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = Arrays.stream(scan.nextLine().split(", ")).
                mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasing = Arrays.stream(scan.nextLine().split(", ")).
                mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> bombPouch = new TreeMap<>();

        bombPouch.putIfAbsent("Datura Bombs", 0);
        bombPouch.putIfAbsent("Cherry Bombs", 0);
        bombPouch.putIfAbsent("Smoke Decoy Bombs", 0);

        boolean fullPouch = false;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {
            int effect = bombEffects.peekFirst();
            int casing = bombCasing.peekLast();

            int sum = effect + casing;

            if (sum != 40 && sum != 60 && sum != 120) {
                casing = casing - 5;
                bombCasing.pollLast();
                bombCasing.addLast(casing);
            } else {
                bombEffects.pollFirst();
                bombCasing.pollLast();
            }

            switch (sum) {
                case 40:
                    bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
                    break;
            }

            if (pouchIsFull(bombPouch)) {
                fullPouch = true;
                break;
            }
        }

        if (fullPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.print("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            printDeq(bombEffects);
        }

        System.out.println();

        if (bombCasing.isEmpty()) {
            System.out.print("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            printDeq(bombCasing);
        }

        System.out.println();

        bombPouch.entrySet().stream().
                forEach(e -> System.out.printf("%s: %s\n", e.getKey(), e.getValue()));
    }

    private static void printDeq(ArrayDeque<Integer> bombDeq) {

        System.out.print(String.join(", ", bombDeq.toString().replaceAll("[\\[\\]]", "")));
    }

    private static boolean pouchIsFull(Map<String, Integer> bombPouch) {
        int daturaBombs = bombPouch.get("Datura Bombs");
        int cherryBombs = bombPouch.get("Cherry Bombs");
        int smokeyDecoyBombs = bombPouch.get("Smoke Decoy Bombs");

        return daturaBombs >= 3 && cherryBombs >= 3 && smokeyDecoyBombs >= 3;
    }
}
