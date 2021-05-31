import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mag = Integer.parseInt(scan.nextLine());
        int zum = Integer.parseInt(scan.nextLine());
        int roz = Integer.parseInt(scan.nextLine());
        int kak = Integer.parseInt(scan.nextLine());
        double pricePresent = Double.parseDouble(scan.nextLine());

        double magPrice = mag * 3.25;
        double zumPrice = zum * 4;
        double rozPrice = roz * 3.50;
        double kakPrice = kak * 8;
        double wholeSum = magPrice + zumPrice + rozPrice + kakPrice;
        double wholeSumTax = wholeSum * 0.05;
        double finalSum = wholeSum - wholeSumTax;

        if (pricePresent > finalSum){
            double noMoney = pricePresent - finalSum;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(noMoney));
        }else {
            double yesMoney = finalSum - pricePresent;
            System.out.printf("She is left with %.0f leva.", Math.floor(yesMoney));
        }
    }
}
