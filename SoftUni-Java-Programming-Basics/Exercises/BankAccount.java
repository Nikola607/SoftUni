import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double totalMoney = 0;
        while (!input.equals("NoMoreMoney")) {
            double number = Double.parseDouble(input);
            if (number < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            totalMoney += number;
            System.out.printf("Increase: %.2f\n", number);
            input = scan.nextLine();
        }
        System.out.printf("Total: %.2f", totalMoney);
    }
}
