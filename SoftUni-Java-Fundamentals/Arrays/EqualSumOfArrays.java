import java.util.Arrays;
import java.util.Scanner;

public class EqualSumOfArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isEqual = false;

        if (numbers.length <= 1) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            int rightSum = 0;
            int leftSum = 0;

            for (int j = i - 1; j>=0; j--) {
                rightSum += numbers[j];
            }
            for (int h = i + 1; h < numbers.length; h++) {
                leftSum += numbers[h];
            }
            if (rightSum == leftSum) {
                isEqual = true;
                System.out.println(i);
                break;
            }
        }
        if (!isEqual) {
            System.out.println("no");
        }
    }
}
