import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> playerOne = parseLineOfNumbers(scan);
        List<Integer> playerTwo = parseLineOfNumbers(scan);

        int sumOne = 0;
        int sumTwo = 0;

        while (playerOne.size() > 0 && playerTwo.size() > 0) {

            if (playerOne.get(0) > playerTwo.get(0)) {

                int winingCard = playerOne.get(0);
                int lostCard = playerTwo.get(0);

                playerOne.add(winingCard);
                playerOne.add(lostCard);

                playerTwo.remove(0);
                playerOne.remove(0);

            } else if (playerOne.get(0) < playerTwo.get(0)) {
                int winingCard = playerTwo.get(0);
                int lostCard = playerOne.get(0);

                playerTwo.add(winingCard);
                playerTwo.add(lostCard);

                playerOne.remove(0);
                playerTwo.remove(0);

            } else {
                playerOne.remove(0);
                playerTwo.remove(0);
            }
        }
            for(int i = 0; i<playerTwo.size(); i++){
                sumTwo+=playerTwo.get(i);
        }
            for(int i = 0; i<playerOne.size(); i++){
                sumOne+=playerOne.get(i);
            }
        if (sumOne > sumTwo) {
            System.out.printf("First player wins! Sum: %d", sumOne);
        } else {
            System.out.printf("Second player wins! Sum: %d", sumTwo);
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
