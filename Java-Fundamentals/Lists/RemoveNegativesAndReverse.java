import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);
        List<Integer> nonNegativeNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                nonNegativeNumbers.add(numbers.get(i));
            }else{
                negativeNumbers.add(numbers.get(i));
            }
        }
        if(negativeNumbers.size()==numbers.size()){
            System.out.print("empty");
        }
        for (int i = nonNegativeNumbers.size() - 1; i>=0; i--){
            System.out.print(nonNegativeNumbers.get(i) + " ");
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
