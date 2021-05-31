package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] bounds = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        List<Integer> numbers = new ArrayList<>();

        String format = scan.nextLine();
        switch (format){
            case"odd":
                isOdd(lowerBound, upperBound, numbers);
                numbers.forEach(e -> System.out.print(e + " "));
                break;
            case"even":
                isEven(lowerBound, upperBound, numbers);
                numbers.forEach(e -> System.out.print(e + " "));
                break;
        }
    }
    public static void isEven(int lowerBound, int upperBound, List<Integer> numbers){
        for(int i = lowerBound; i<=upperBound; i++){
            if(i%2==0){
                numbers.add(i);
            }
        }
    }
    public static void isOdd(int lowerBound, int upperBound, List<Integer> numbers){
        for(int i = lowerBound; i<=upperBound; i++){
            if(i%2!=0){
                numbers.add(i);
            }
        }
    }
}
