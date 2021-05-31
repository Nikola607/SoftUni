import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> listOne = parseLineOfNumbers(scan);
        List<Integer> listTwo = parseLineOfNumbers(scan);

        List<Integer> mergedLists = new ArrayList<>();
        int j = 0;

        while (j < listOne.size() || j < listTwo.size()) {
            if(j<listOne.size()){
                mergedLists.add(listOne.get(j));
            }
            if(j<listTwo.size()){
                mergedLists.add(listTwo.get(j));
            }
            j++;
        }
        for (int i : mergedLists) {
            System.out.print(i + " ");
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
