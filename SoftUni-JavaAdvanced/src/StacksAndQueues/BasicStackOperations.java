package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] values = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int num = values[0];
        int remove = values[1];
        int contain = values[2];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        if (numbers.length > 0) {           //check if array is empty
            for (int i = 0; i < num; i++) {       //we add the numbers to the stack
                deq.push(numbers[i]);
            }
            for (int i = 1; i <= remove; i++) {   //we remove the given amount of numbers
                deq.pop();
            }
            if(!deq.isEmpty()) {     //2nd check if the stack is empty after removing the numbers
                if (deq.contains(contain)) {     //we check for number in the stack
                    System.out.println("true");
                } else {
                    int min = Collections.min(deq); //we find the smallest number
                    System.out.println(min);
                }
            }else{
                System.out.println(0);
            }
        }else{
            System.out.println(0);
        }
    }
}
