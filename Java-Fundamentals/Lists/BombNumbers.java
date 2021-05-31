import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = parseLineOfNumbers(scan);
        List<Integer> bombAndPower = parseLineOfNumbers(scan);

        int bombNumber = bombAndPower.get(0);
        int powerNumber = bombAndPower.get(1);

        while(numbers.contains(bombNumber)){
            int bombIndex = numbers.indexOf(bombNumber);

            int leftBound = Math.max(0, bombIndex - powerNumber);
            int rightBound = Math.min(numbers.size() - 1, bombIndex + powerNumber);

            for(int i = rightBound; i>=leftBound; i--){
                numbers.remove(i);
            }
        }
        int sum = 0;
        for(int i = 0; i<numbers.size(); i++){
            sum+=numbers.get(i);
        }
        System.out.println(sum);
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