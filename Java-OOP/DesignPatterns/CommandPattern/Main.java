package DesignPatterns.CommandPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String productName = scan.nextLine();
        int productPrice = Integer.parseInt(scan.nextLine());

        ModifyPrice modifyPrice = new ModifyPrice();
        Product product = new Product(productName, productPrice);

        execute(modifyPrice, new IncreaseProductPriceCommand(product, 100));
        execute(modifyPrice, new DecreaseProductPriceCommand(product, 25));
        System.out.print(product);
    }

    private static void execute(ModifyPrice modifyPrice, Command command){
        modifyPrice.setCommand(command);
        modifyPrice.invoke();
    }
}

//    String price = scan.nextLine();
//
//        while (price.equals("Stop")){
//                switch (scan.nextLine()){
//                case "increase":
//                execute(modifyPrice ,new IncreaseProductPriceCommand(product, Integer.parseInt(price)));
//                break;
//                case"decrease":
//                execute(modifyPrice, new DecreaseProductPriceCommand(product, Integer.parseInt(price)));
//                break;
//                }
//
//                price = scan.nextLine();
//                }
