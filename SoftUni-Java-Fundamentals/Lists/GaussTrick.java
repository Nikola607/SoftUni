import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);
        for (int i = 0; i < numbers.size() / 2; i++) {
            int sum = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
            System.out.print(sum + " ");
        }
        if(numbers.size()%2!=0) {
            System.out.println(numbers.get(numbers.size() / 2));
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
