package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lengthNeeded = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> filterNames = name -> name.length() <= lengthNeeded;

        Arrays.stream(names).filter(filterNames).forEach(e -> System.out.println(e));
    }
}
