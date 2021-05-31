package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            String[] commands = scan.nextLine().split("\\s+");

            switch (commands[0]) {
                case "1":
                    int numberToPush = Integer.parseInt(commands[1]);
                    deq.push(numberToPush);
                    break;
                case "2":
                    deq.pop();
                    break;
                case "3":
                    int max = Collections.max(deq);
                    System.out.println(max);
                    break;
            }
        }
    }
}
