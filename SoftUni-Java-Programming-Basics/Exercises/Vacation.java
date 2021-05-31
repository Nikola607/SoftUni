
import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double moneyForExcursion = Double.parseDouble(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        int daysSpend = 0;
        int daysPassed = 0;
        boolean isEnough = true;

        while (budget < moneyForExcursion && daysSpend<5 ) {
            String command = scan.nextLine();
            double moneyToSafe = Double.parseDouble(scan.nextLine());
            daysPassed++;
            if (command.equals("spend")) {
                budget -= moneyToSafe;
                daysSpend++;
                if (budget < 0) {
                    budget = 0;
                }
            } else {
                budget += moneyToSafe;
                daysSpend = 0;
            }
            if (daysSpend == 5) {
                isEnough = false;
                break;
            }
        }
        if (isEnough) {
            System.out.printf("You saved the money for %d days.", daysPassed);
        } else {
            System.out.println("You can't save the money.");
            System.out.printf("%d", daysPassed);
        }
    }
}
