import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int allNumbers = Integer.parseInt(scan.nextLine());
        int divideTwo = 0;
        int divideThree = 0;
        int divideFour = 0;

        for (int i = 1; i <= allNumbers; i++) {
            int currentNumber = Integer.parseInt(scan.nextLine());
            if (currentNumber % 2 == 0) {
                divideTwo++;
            }
            if (currentNumber % 3 == 0) {
                divideThree++;
            }
            if (currentNumber % 4 == 0) {
                divideFour++;
            }
        }
        System.out.printf("%.2f%%\n", 1.0 * divideTwo / allNumbers * 100);
        System.out.printf("%.2f%%\n", divideThree * 1.0 / allNumbers * 100);
        System.out.printf("%.2f%%", divideFour * 1.0 / allNumbers * 100);
    }
}
