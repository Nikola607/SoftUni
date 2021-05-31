import java.util.Scanner;

public class CelsiusToFarenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double farenheit = Double.parseDouble(scan.nextLine());
        double celsius = farenheit * 1.8 + 32;
        System.out.printf("%.2f", celsius);
    }
}
