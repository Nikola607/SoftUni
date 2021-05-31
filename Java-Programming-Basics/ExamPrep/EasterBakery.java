import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double flourPrice = Double.parseDouble(scan.nextLine());
        double flourKg = Double.parseDouble(scan.nextLine());
        double sugarKg = Double.parseDouble(scan.nextLine());
        int eggs = Integer.parseInt(scan.nextLine());
        double yeast = Double.parseDouble(scan.nextLine());

        double sugarPrice = flourPrice - flourPrice * 0.25;
        double eggsPrice = flourPrice + flourPrice * 0.1;
        double yeastPrice = sugarPrice - sugarPrice * 0.8;
        double flourMoney = flourPrice * flourKg;
        double eggsMoney = eggsPrice * eggs;
        double yeastMoney = yeastPrice * yeast;
        double sugarMoney = sugarKg * sugarPrice;

        double wholeSum = flourMoney + eggsMoney + sugarMoney + yeastMoney;

        System.out.printf("%.2f", wholeSum);
        }
    }
