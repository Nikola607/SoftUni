import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceOver20 = Double.parseDouble(scan.nextLine());
        double kgBags = Double.parseDouble(scan.nextLine());
        int daysToTrip = Integer.parseInt(scan.nextLine());
        int numbersOfBags = Integer.parseInt(scan.nextLine());
        double sumBags = 0;
        double sumDays = 0;

        if (kgBags < 10) {
            sumBags = priceOver20 * 0.2;
        } else if (kgBags >= 10 && kgBags <= 20) {
            sumBags = priceOver20 / 2;
        } else if (kgBags > 20) {
            sumBags = priceOver20;
        }
        if (daysToTrip > 30) {
            sumDays = sumBags + sumBags * 0.1;
        } else if (daysToTrip >= 7) {
            sumDays = sumBags + sumBags * 0.15;
        } else{
            sumDays = sumBags + sumBags * 0.4;
        }
        sumDays *= numbersOfBags;
        System.out.printf("The total price of bags is: %.2f lv.", sumDays);
    }
}
