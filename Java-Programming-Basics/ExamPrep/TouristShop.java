import java.util.Scanner;

public class TouristShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String command = scan.nextLine();
        int productsBought = 0;
        double sum = 0;

        while (!command.equals("Stop")) {
            int pricePerProduct = Integer.parseInt(scan.nextLine());
            sum += pricePerProduct;
            productsBought++;
            if (productsBought % 3 == 0) {
                sum = sum - sum * 0.5;
            }
            if (budget < sum) {
                break;
            }
            command = scan.nextLine();
        }
        if(command.equals("Stop")){
            System.out.printf("You bought %d products for %.2f leva.\n", productsBought, sum);
        }else if(budget < sum){
            System.out.println("You don't have enough money.");
        }
    }
}
