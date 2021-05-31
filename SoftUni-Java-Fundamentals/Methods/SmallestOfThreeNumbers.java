import java.util.Arrays;
import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        printSmallestNumber(num1, num2, num3);
    }

    private static void printSmallestNumber(int num1, int num2, int num3) {
        int[] numArray = {num1, num2, num3};

        Arrays.sort(numArray);
        System.out.println(numArray[0]);
    }
}
