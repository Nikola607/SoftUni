import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListsTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = parseLineOfNumbers(scan);
        boolean isEqual = true;
        while (isEqual) {
            isEqual = false;
            for (int i = 0; i < numbers.size() - 1; i++) {
                double current = numbers.get(i);
                double next = numbers.get(i + 1);
                if (current == next) {
                    numbers.remove(next);
                    numbers.set(i, current + next);
                    isEqual = true;
                    break;
                }
            }
            for (double i : numbers){
                System.out.print(new DecimalFormat("o.#") + " ");
            }
        }
    }


    public static List<Double> parseLineOfNumbers(Scanner scan) {
        String line = scan.nextLine();
        String[] numbersAsStrings = line.split(" ");
        List<Double> numbers = new ArrayList<>();

        for (String i : numbersAsStrings) {
            double number = Integer.parseInt(i);
            numbers.add(number);
        }
        return numbers;
    }
}

