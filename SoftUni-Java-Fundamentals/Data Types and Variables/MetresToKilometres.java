import java.util.Scanner;

public class MetresToKilometres {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int metres = Integer.parseInt(scan.nextLine());

        double toKilometres  = metres * 1.0 / 1000;
        System.out.printf("%.2f", toKilometres);
    }
}
