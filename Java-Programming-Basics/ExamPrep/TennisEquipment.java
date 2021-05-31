import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceRaketa = Double.parseDouble(scan.nextLine());
        int numberOfRaketi = Integer.parseInt(scan.nextLine());
        int shoes = Integer.parseInt(scan.nextLine());
        double priceShoes = priceRaketa * 1 / 6;
        double raketisPrice = priceRaketa * numberOfRaketi;
        double wholeSum = (priceShoes * shoes + raketisPrice) * 0.2;
        double finalSum = wholeSum + raketisPrice + priceShoes * shoes;

        System.out.printf("Price to be paid by Djokovic %.0f\n", Math.floor(finalSum * 1 / 8));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(finalSum * 7 / 8));
    }
}
