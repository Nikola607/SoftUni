import java.util.Scanner;

public class DivideWithoutReminder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int divideTwo = 0;
        int divideThree = 0;
        int divideFour = 0;

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(scan.nextLine());
            if (value % 2 == 0) {
                divideTwo++;
            }
            if (value % 3 == 0) {
                divideThree++;
            }
            if (value % 4 == 0) {
                divideFour++;
            }
        }
        double twoP = divideTwo * 1.0 / n * 100;
        double threeP = divideThree * 1.0 / n * 100;
        double fourP = divideFour * 1.0 / n * 100;

        System.out.printf("%.2f%%\n", twoP);
        System.out.printf("%.2f%%\n", threeP);
        System.out.printf("%.2f%%\n", fourP);
    }
}
