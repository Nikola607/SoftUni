import java.util.Scanner;

public class TrapezoidArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Integer.parseInt(scan.nextLine());
        double b = Integer.parseInt(scan.nextLine());
        double h= Integer.parseInt(scan.nextLine());

        System.out.printf("%.2f", (a + b) * h / 2);
    }
}
