
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        Integer[] arr = {num1, num2, num3};

        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i<=arr.length; i++ ){
            System.out.println(arr [i]);
        }
    }
}
