import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int countStatists = Integer.parseInt(scan.nextLine());
        double pricePerStatist = Double.parseDouble(scan.nextLine());

        double decorPrice = 0.10 * budget;
        double clothesPrice = countStatists * pricePerStatist;

        if(countStatists > 150){
            clothesPrice = clothesPrice - 0.10 * clothesPrice;
        }
        double expenses = decorPrice + clothesPrice;
        if( budget >= expenses ){
            System.out.println("Action!");
            double leftMoney = budget - expenses;
            System.out.printf("Wingard starts filming with %f money left.", leftMoney);
        }else{
            System.out.println("Not enough money!");
            double moneyNeeded = expenses - budget;
            System.out.printf("Wingard needs %.2f money more.", moneyNeeded);
        }
    }
}
