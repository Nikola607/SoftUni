package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> deq = new ArrayDeque<>();
        Collections.addAll(deq, input);
        int num = Integer.parseInt(scan.nextLine());


        while (deq.size() > 1) {

            for(int i = 1; i<num; i++){
                deq.offer(deq.poll());
            }
            System.out.println("Removed " + deq.poll());
        }
        System.out.println("Last is " + deq.poll());
    }
}
