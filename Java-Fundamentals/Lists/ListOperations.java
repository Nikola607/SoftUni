import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);
        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] commandArray = command.split(" ");
            switch (commandArray[0]) {
                case "Add":
                    int addNumber = Integer.parseInt(commandArray[1]);
                    numbers.add(addNumber);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(commandArray[1]);
                    int index = Integer.parseInt(commandArray[2]);
                    if (index > numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(index, insertNumber);
                    }
                    break;
                case "Remove":
                    int removeNumber = Integer.parseInt(commandArray[1]);
                    if (removeNumber > numbers.size() || removeNumber < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(removeNumber);
                    }
                    break;
                case "Shift":
                    int shiftNumber = Integer.parseInt(commandArray[2]);
                    for (int j = 0; j < shiftNumber; j++) {
                        if (commandArray[1].equals("left")) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        } else {
                            int currentLast = numbers.get(numbers.size() - 1);
                            numbers.add(0, currentLast);
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }

    public static List<Integer> parseLineOfNumbers(Scanner scan) {
        String line = scan.nextLine();

        String[] numbersAsString = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String i : numbersAsString) {
            int number = Integer.parseInt(i);
            numbers.add(number);
        }
        return numbers;
    }
}
