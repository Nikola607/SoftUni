package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> productList = new ArrayList<>();
        double sum = 0;

        Pattern pattern = Pattern.compile("\\>>(?<product>[A-Za-z]+)\\<<(?<price>\\d+\\.?\\d*)\\!(?<quantity>\\d+)");

        String input = scan.nextLine();

        while(!input.equals("Purchase")){
            Matcher match = pattern.matcher(input);

            if(match.find()){
                String products = match.group("product");

                double price = Double.parseDouble(match.group("price"));
                int quantity = Integer.parseInt(match.group("quantity"));

                productList.add(products);
                sum +=price * quantity;
            }

            input=scan.nextLine();
        }
        System.out.println("Bought furniture:");

        productList.
        forEach(System.out::println);

        System.out.printf("Total money spend: %.2f\n", sum);
    }
}
