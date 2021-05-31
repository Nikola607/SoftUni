package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<int[], Integer> function = num -> Arrays.stream(num).min().getAsInt();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        System.out.println(function.apply(numbers));
    }
}
