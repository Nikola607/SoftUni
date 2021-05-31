package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();

        Consumer<int[]> printNumbers = arr -> Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        String commands = scan.nextLine();
        while (!commands.equals("end")) {
            switch (commands) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printNumbers.accept(numbers);
                    System.out.println();
                    break;
            }
            commands = scan.nextLine();
        }
    }
}
