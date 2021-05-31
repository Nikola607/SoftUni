import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int hour = Integer.parseInt(scan.nextLine());
        double sum = 0;

        for (int i = 1; i <= days; i++) {
            double currentDay = 0;
            for (int j = 1; j <= hour; j++) {
                if (i % 2 == 0 && j % 2 == 1) {
                    currentDay += 2.5;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    currentDay += 1.25;
                } else {
                    currentDay += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva\n", i, currentDay);
            sum+=currentDay;
        }
        System.out.printf("Total: %.2f leva", sum);
    }
}
