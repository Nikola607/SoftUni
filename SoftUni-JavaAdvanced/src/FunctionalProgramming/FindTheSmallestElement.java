package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function = arr -> arr.lastIndexOf(arr.stream().min(Integer::compareTo).get());

        System.out.println(function.apply(list));
    }
}
