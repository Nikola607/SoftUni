package SetAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        Map<String, Map<String, Double>> map = new TreeMap<>();

        while (!input[0].equals("Revision")){
            String name = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            map.putIfAbsent(name, new LinkedHashMap<>());
            map.get(name).put(product, price);

            input = scan.nextLine().split(", ");
        }

        map.entrySet().stream().forEach(e ->{
            System.out.println(e.getKey() + "->");
            e.getValue().
                    forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f\n", k, v));
        });
    }
}
