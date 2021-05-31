import java.util.Arrays;
import java.util.Scanner;

public class ArraysEqual {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrOne = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] arrTwo = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        boolean isEqual = true;

        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i] == arrTwo[i]) {
                sum += arrTwo[i];
            } else {
                isEqual = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        if(isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}

