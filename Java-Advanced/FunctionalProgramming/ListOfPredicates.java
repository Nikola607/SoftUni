package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Set<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> predicate = num ->{
            for(Integer currentNum : numbers){
                if(num % currentNum != 0){
                    return false;
                }
            }
            return true;
        };

        for(int i = 1; i<=number; i++){
            if(predicate.test(i)){
                System.out.print(i + " ");
            }
        }
    }
}
