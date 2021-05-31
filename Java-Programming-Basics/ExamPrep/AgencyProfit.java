import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int adultTickets = Integer.parseInt(scan.nextLine());
        int childTickets = Integer.parseInt(scan.nextLine());
        double adultPrice = Double.parseDouble(scan.nextLine());
        double tax = Double.parseDouble(scan.nextLine());

        double childPrice = adultPrice - adultPrice * 0.7;
        double adultTax = adultPrice + tax;
        double childTax = childPrice + tax;
        double wholePrice = adultTax * adultTickets + childTax * childTickets;
        double profit = wholePrice * 0.2;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",name , profit);
    }
}
