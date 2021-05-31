import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int newBest = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    if (count > maxCount) {
                     maxCount = count;
                        newBest = i;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(arr[i + newBest] + " ");
        }
    }
}
