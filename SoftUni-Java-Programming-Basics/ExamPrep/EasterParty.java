import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  guests = Integer.parseInt(scan.nextLine());
        double pricePerGuest = Double.parseDouble(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        double priceOff = 0;

        if(guests>=10 && guests<=15){
            priceOff = (pricePerGuest - pricePerGuest * 0.15) * guests;
        }
        else if(guests>15 && guests<=20){
            priceOff = (pricePerGuest - pricePerGuest * 0.2) * guests;
        }
        else if(guests>20) {
            priceOff = (pricePerGuest - pricePerGuest * 0.25) * guests;
        }else{
            priceOff = guests * pricePerGuest;
        }
        double priceForGuests = priceOff ;
        double priceCake = budget * 0.1;
        double wholeSum = priceForGuests + priceCake;
        if(budget >= wholeSum){
            double moneyLeft = budget - wholeSum;
            System.out.printf("It is party time! %.2f leva left.", moneyLeft);
        }else{
            double moneyNeeded = wholeSum - budget;
            System.out.printf("No party! %.2f leva needed.", moneyNeeded);
        }
    }
}
