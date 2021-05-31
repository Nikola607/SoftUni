package ExamPreparation.hell;

import ExamPreparation.hell.entities.ManagerImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ManagerImpl manager = new ManagerImpl();
        String command = scan.nextLine();

        while (!command.equals("Quit")) {
            String[] commandArray = command.split("\\s+");
            String result = "";
            switch (commandArray[0]) {
                case "Hero":
                    result = manager.addHero(Arrays.asList(commandArray[1], commandArray[2]));
                    break;
                case "Item":
                    result = manager.addItem(Arrays.asList(commandArray));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(commandArray));
                    break;
                case "Inspect":
                    result = manager.inspect(Arrays.asList(commandArray));
                    break;

            }
            System.out.println(result);
            command = scan.nextLine();
        }
        System.out.println(manager.quit());
    }
}