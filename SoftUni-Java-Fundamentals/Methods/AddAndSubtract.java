import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int sum = printSumTwoNumbers(num1, num2);
        int subtract = printSubtract(sum, num3);
        System.out.println(subtract);
    }

    private static int printSubtract(int sum, int num3) {
        return sum - num3;
    }

    private static int printSumTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }
}
