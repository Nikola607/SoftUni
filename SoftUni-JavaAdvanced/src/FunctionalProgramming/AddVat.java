package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scan.nextLine().split(", ")).
                map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> priceWithVat = x -> x*1.2;
        System.out.println("Prices with VAT:");

        numbers.stream().forEach(e-> System.out.printf("%.2f\n", priceWithVat.apply(e)));
    }
}
