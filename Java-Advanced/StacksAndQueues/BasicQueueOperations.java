package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] values = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                toArray();
        int num = values[0];
        int remove = values[1];
        int contain = values[2];
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                toArray();
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        if(numbers.length>0){
            for(int i = 0; i<num; i++){
                deq.offer(numbers[i]);
            }

            for(int i = 0; i<remove; i++){
                deq.poll();
            }

            if(!deq.isEmpty()){
                if(deq.contains(contain)){
                    System.out.println("true");
                }else{
                    System.out.println(Collections.min(deq));
                }
            }
            else{
                System.out.println(0);
            }
        }else{
            System.out.println(0);
        }
    }
}
