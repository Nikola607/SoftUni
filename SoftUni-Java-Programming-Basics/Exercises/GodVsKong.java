import java.util.Scanner;

public class GodVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double clothingPerStatists = Double.parseDouble(scan.nextLine());
        double sumForDecor = budget * 0.1;
        double sumForClothing = statists * clothingPerStatists;
        if (statists >= 150){
            sumForClothing = sumForClothing - sumForClothing * 0.1;
        }
        double wholePrice = sumForClothing + sumForDecor;
        if ( wholePrice <= budget){
            double finalPrice = budget - wholePrice;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", finalPrice);
        }else{
            double noFinalPrice = wholePrice - budget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", noFinalPrice);
        }
    }
}

