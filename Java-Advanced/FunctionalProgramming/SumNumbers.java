package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(", ");

        if (numbers.length < 2) {
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + numbers[0]);
        } else {
            Function<String, Integer> function = e -> Integer.parseInt(e);
            int sum = 0;
            for (String s: numbers) {
                sum+=function.apply(s);
            }
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + sum);
        }
    }
}
