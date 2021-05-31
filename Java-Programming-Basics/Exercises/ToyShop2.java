import java.util.Scanner;

public class ToyShop2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceForTrip = Double.parseDouble(scan.nextLine());
        int puzzles = Integer.parseInt(scan.nextLine());
        int dolls = Integer.parseInt(scan.nextLine());
        int bears = Integer.parseInt(scan.nextLine());
        int minions = Integer.parseInt(scan.nextLine());
        int trucks = Integer.parseInt(scan.nextLine());

        double starterPrice = puzzles * 2.60 + dolls * 3 + bears * 4.10 + minions * 8.20 + trucks * 2;
        double numberOfToys = trucks + puzzles + dolls + minions + bears;
        if (numberOfToys >= 50){
             starterPrice = starterPrice - starterPrice * 0.25;
        }
        double priceWithRent = starterPrice - starterPrice * 0.10;
        if (priceWithRent >= priceForTrip){
            double profit = priceWithRent - priceForTrip;
            System.out.printf("Yes! %.2f lv left.", profit );
        }else{
            double profitt = priceForTrip - priceWithRent;
            System.out.printf("Not enough money! %.2f lv needed.", profitt);
        }
    }
}
