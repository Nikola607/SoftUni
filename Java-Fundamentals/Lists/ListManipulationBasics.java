import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);
        String command = scan.nextLine();
        while(!command.equals("end")){
            String[] arrayCommand = command.split(" ");
            switch(arrayCommand[0]){
                case"Add":
                    int add = Integer.parseInt(arrayCommand[1]);
                    numbers.add(add);
                    break;
                case"Remove":
                    int remove = Integer.parseInt(arrayCommand[1]);
                    numbers.remove(Integer.valueOf(remove));
                    break;
                case"RemoveAt":
                    int removeAt = Integer.parseInt(arrayCommand[1]);
                    numbers.remove(removeAt);
                    break;
                case"Insert":
                    int number = Integer.parseInt(arrayCommand[1]);
                    int index = Integer.parseInt(arrayCommand[2]);
                    numbers.add(index, number);
                    break;
            }
            command = scan.nextLine();
        }
        for(int i : numbers){
            System.out.print(i + " ");
        }
    }

    public static List<Integer> parseLineOfNumbers(Scanner scan) {
        String line = scan.nextLine();
        String[] numbersAsStrings = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String i : numbersAsStrings) {
            int number = Integer.parseInt(i);
            numbers.add(number);
        }
        return numbers;
    }
}
