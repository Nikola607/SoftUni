import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceForKgVegetables = Double.parseDouble(scan.nextLine());
        double priceForKgFruits = Double.parseDouble(scan.nextLine());
        int wholeVegetables = Integer.parseInt(scan.nextLine());
        int wholeFruits = Integer.parseInt(scan.nextLine());

        double Vegetables = wholeVegetables * priceForKgVegetables;
        double Fruits = wholeFruits * priceForKgFruits;
        double profit = Vegetables + Fruits;
        double profitInEU = profit / 1.94;
        System.out.printf("%.2f", profitInEU);
    }
}
