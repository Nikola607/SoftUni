import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tax = Integer.parseInt(scan.nextLine());
        double shoes = tax - tax * 0.4;
        double equipment = shoes - shoes * 0.2;
        double ball = equipment * 1 / 4;
        double accessories = ball * 1 / 5;
        double wholeSum = shoes + equipment + ball + accessories + tax;
        System.out.printf("%.2f", wholeSum);
    }
}
