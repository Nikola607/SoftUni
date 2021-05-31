package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Double> orders = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> rememberProducts = new LinkedHashMap<>();

        String[] command = scan.nextLine().split(" ");

        while (!command[0].equals("buy")) {
            for (int i = 0; i < command.length; i += 3) {

                String product = command[i];
                double price = Double.parseDouble(command[i + 1]);
                int quantity = Integer.parseInt(command[i + 2]);

                if(!orders.containsKey(product)){
                    orders.put(product,quantity*price);
                    rememberProducts.put(product, quantity);

                }else {
                    rememberProducts.put(product, rememberProducts.get(product) + quantity);
                    orders.put(product, rememberProducts.get(product) * price);
                }

            }

            command = scan.nextLine().split(" ");
        }

        orders.forEach((key, value) -> System.out.printf("%s -> %.2f\n", key, value));
    }
}
