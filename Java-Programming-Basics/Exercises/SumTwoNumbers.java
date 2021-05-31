import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magickNumber = Integer.parseInt(scan.nextLine());
        int combinations = 0;
        boolean isFound = false;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                combinations++;
                if (i + j == magickNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)\n", combinations, i, j, magickNumber);
                    break;
                }
            }
            if (isFound) {
                break;
            }
            if (!isFound) {
                System.out.printf("%d combinations + neither equals %d", combinations, magickNumber);
            }
        }
    }
}