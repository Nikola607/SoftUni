import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        char symbol = scan.nextLine().charAt(0);
        double num2 = Double.parseDouble(scan.nextLine());
        printResult(num1, num2, symbol);
    }

    private static void printResult(double num1, double num2, char symbol) {
        switch (symbol) {
            case '/':
                System.out.printf("%.0f", num1 / num2);
                break;
            case '*':
                System.out.printf("%.0f", num1 * num2);
                break;
            case '+':
                System.out.printf("%.0f", num1 + num2);
                break;
            case '-':
                System.out.printf("%.0f", num1 - num2);
                break;
        }
    }
}
