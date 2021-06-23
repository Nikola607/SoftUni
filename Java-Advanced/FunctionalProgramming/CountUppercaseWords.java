package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = Arrays.stream(scan.nextLine().split(" ")).
        filter(isUpperCase.predicate).collect(Collectors.toList());

        System.out.println(list.size());
        System.out.println(list.stream().collect(Collectors.joining(System.lineSeparator())));
    }
    static class isUpperCase{
        public static
        Predicate<String> predicate
                = word -> Character.isUpperCase(word.charAt(0));
    }
}
