import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = parseLineOfNumbers(scan);
        int capacity = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] commandArray = command.split(" ");
            if (commandArray[0].equals("Add")) {
                int people = Integer.parseInt(commandArray[1]);
                wagons.add(people);
            } else {
                int people = Integer.parseInt(commandArray[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int finalCount = wagons.get(i) + people;
                    if (finalCount <= capacity) {
                        wagons.set(i, finalCount);
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        for(int i = 0; i<wagons.size(); i++){
            System.out.print(wagons.get(i) + " ");
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
