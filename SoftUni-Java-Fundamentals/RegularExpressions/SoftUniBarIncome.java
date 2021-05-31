package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$");

        String input = scan.nextLine();
        double sum = 0;

        while (!input.equals("end of shift")) {
            Matcher match = pattern.matcher(input);

            if(match.find()){
                String name = match.group("name");
                String product = match.group("product");

                int count = Integer.parseInt(match.group("count"));
                double price = Double.parseDouble(match.group("price"));

                double pricePerProduct = count * price;
                sum+=pricePerProduct;
                System.out.printf("%s: %s - %.2f\n", name, product, pricePerProduct);
            }

            input = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", sum);
    }
}
