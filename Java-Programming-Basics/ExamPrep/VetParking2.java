import java.util.Scanner;

public class VetParking2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());
        double total = 0;

        for (int i = 1; i <= days; i++) {
            double price = 0;
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    price += 2.50;
                } else if (i % 2 != 0 && j % 2 == 0){
                    price+=1.25;
                } else{
                    price+=1;
                }
            }
            total+=price;
            System.out.printf("Day: %d - %.2f leva\n", i, price);
        }
        System.out.printf("Total: %.2f leva", total);
    }
}
