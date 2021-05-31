package Exercises;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int health = 100;
        int bitCoins = 0;
        int currentRoom = 0;
        boolean isDed = false;

        for (int i = 0; i < rooms.length; i++) {
            String command = rooms[i];
            String[] commandArray = command.split(" ");
            currentRoom++;

            if (commandArray[0].equals("potion")) {
                int currentHealth = health;
                health += Integer.parseInt(commandArray[1]);
                if (health > 100) {
                    health = 100;
                    int amount = 100 - currentHealth;
                    System.out.printf("You healed for %d hp.\n", amount);
                    System.out.println("Current health: 100 hp.");
                } else {
                    System.out.printf("You healed for %d hp.\n", Integer.parseInt(commandArray[1]));
                    System.out.printf("Current health: %d hp.\n", health);
                }
            } else if (commandArray[0].equals("chest")) {
                int bitcoinsFound = Integer.parseInt(commandArray[1]);
                System.out.printf("You found %d bitcoins.\n", bitcoinsFound);
                bitCoins += bitcoinsFound;
            } else {
                health -= Integer.parseInt(commandArray[1]);
                if (health <= 0) {
                    isDed = true;
                    System.out.printf("You died! Killed by %s.\n", commandArray[0]);
                    System.out.printf("Best room: %d", currentRoom);
                    break;
                } else {
                    System.out.printf("You slayed %s.\n", commandArray[0]);
                }
            }
        }
        if (!isDed) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitCoins);
            System.out.printf("Health: %d", health);
        }
    }
}
