import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfGuests = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double numberOfCakes = numberOfGuests * 1.0 / 3;
        double cakesUp = Math.ceil(numberOfCakes);
        double numberOfEggs = numberOfGuests * 2;
        double priceCakes = cakesUp * 4;
        double priceEggs = numberOfEggs * 0.45;
        double wholeSum = priceCakes + priceEggs;

        if (budget >= wholeSum) {
            double leftMoney = budget - wholeSum;
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.\n",cakesUp, numberOfEggs);
            System.out.printf("He has %.2f lv. left.", leftMoney);
        } else {
            double neededMoney = wholeSum - budget;
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.", neededMoney);
        }
    }
}
