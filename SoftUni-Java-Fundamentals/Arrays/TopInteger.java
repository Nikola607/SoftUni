import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e)).toArray();
        for(int i = 0; i<numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean topInteger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber <= numbers[j]) {
                    topInteger = false;
                }
            }
            if (topInteger) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
