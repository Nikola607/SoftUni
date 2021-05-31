package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        int num = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);
        numbers.stream().filter(n -> n % num !=0).forEach(e -> System.out.print(e + " "));
    }
}
