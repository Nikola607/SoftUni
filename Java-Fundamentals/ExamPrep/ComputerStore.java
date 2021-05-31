package Excercises;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String prices = scan.nextLine();
        double withoutTaxes = 0;

        while (!prices.equals("special")) {
            if(prices.equals("regular")){
                break;
            }
            double currentPrice = Double.parseDouble(prices);
            if(currentPrice<0){
                System.out.println("Invalid price!");
            }else {
                withoutTaxes += currentPrice;
            }
            prices = scan.nextLine();
        }

        double withTaxes =withoutTaxes * 0.2;
        double totalPrice = withoutTaxes + withTaxes;

        if(totalPrice<=0){
            System.out.println("Invalid order!");
        }else {
            if (prices.equals("special")) {
                totalPrice -= totalPrice * 0.1;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", withoutTaxes);
            System.out.printf("Taxes: %.2f$\n", withTaxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
