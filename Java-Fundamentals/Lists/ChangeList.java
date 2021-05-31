import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] commandArray = command.split(" ");
            switch (commandArray[0]) {
                case "Delete":
                    int numbersToDelete = Integer.parseInt(commandArray[1]);
                    while (numbers.contains(numbersToDelete)) {
                        numbers.remove(numbersToDelete);
                    }
                    break;
                case "Insert":
                    int element = Integer.parseInt(commandArray[1]);
                    int position = Integer.parseInt(commandArray[2]);
                    if (position < numbers.size()) {
                        numbers.add(position, element);
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
