package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deq = Arrays.stream(scan.nextLine().split("\\s+")).
                collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<String> newDeq = new ArrayDeque<>();

       for(String i : deq){
           newDeq.push(i);
       }

        while (!newDeq.isEmpty()){
            System.out.print(newDeq.pop() + " ");
        }
    }
}
