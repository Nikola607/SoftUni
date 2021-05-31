import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        double result = 1;
        printResult(number, power, result);
    }

    private static void printResult(double number, int power, double result) {
        for(int i = 0; i<power; i++){
            result *=number;
        }
        System.out.print(new DecimalFormat("0.####").format(result));
    }
}
