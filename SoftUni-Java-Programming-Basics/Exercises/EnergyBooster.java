import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String size = scan.nextLine();
        int numbersSets = Integer.parseInt(scan.nextLine());
        double typeOfFruit = 0;
        double finalPrice = 0;

        switch (fruit) {
            case "Watermelon":
                switch (size) {
                    case "small":
                        typeOfFruit = 2 * 56;
                        break;
                    case "big":
                        typeOfFruit = 5 * 28.70;
                        break;
                }
                break;
            case "Mango":
                switch (size) {
                    case "small":
                        typeOfFruit = 2 * 36.66;
                        break;
                    case "big":
                        typeOfFruit = 5 * 19.60;
                        break;
                }
                break;
            case "Pineapple":
                switch (size) {
                    case "small":
                        typeOfFruit = 2 * 42.10;
                        break;
                    case "big":
                        typeOfFruit = 5 * 24.80;
                        break;
                }
                break;
            case "Raspberry":
                switch (size) {
                    case "small":
                        typeOfFruit = 2 * 20;
                        break;
                    case "big":
                        typeOfFruit = 5 * 15.20;
                        break;
                }
                break;
        }
        double priceWithSets = numbersSets * typeOfFruit;
        if (priceWithSets >= 400 && priceWithSets <= 1000) {
            double priceOff = priceWithSets * 0.15;
            finalPrice = priceWithSets - priceOff;
            System.out.printf("%.2f lv.", finalPrice);
        } else if (priceWithSets > 1000) {
            double priceOff = priceWithSets * 0.5;
            finalPrice = priceWithSets - priceOff;
            System.out.printf("%.2f lv.", finalPrice);
        }else{
           double simplePrice = priceWithSets;
            System.out.printf("%.2f lv.", simplePrice);
        }
    }
}
