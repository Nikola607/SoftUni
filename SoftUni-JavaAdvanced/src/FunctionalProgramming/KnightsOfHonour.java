package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> printNames = names -> System.out.println("Sir " + names);
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(printNames);
    }
}
