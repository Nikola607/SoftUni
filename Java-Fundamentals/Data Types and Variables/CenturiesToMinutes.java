import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int centuries = Integer.parseInt(scan.nextLine());
        int centuriesToYears = centuries * 100;
        int days = (int) (centuriesToYears * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, centuriesToYears, days, hours, minutes);
    }
}
