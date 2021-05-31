

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();

        while (!destination.equals("End")) {
            double minimumBudget = Double.parseDouble(scan.nextLine());
            int sum = 0;
            while (sum < minimumBudget) {
                double currentMoney = Double.parseDouble(scan.nextLine());
                sum += currentMoney;
            }
            System.out.printf("Going to %s!\n", destination);
            destination = scan.nextLine();
        }
    }
}
