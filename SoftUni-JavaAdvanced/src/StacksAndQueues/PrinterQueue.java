package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deq = new ArrayDeque<>();
        String input = scan.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (!deq.isEmpty()) {
                    System.out.printf("Canceled %s\n", deq.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                deq.offer(input);
            }
            input = scan.nextLine();
        }

        while (!deq.isEmpty()){
            System.out.println(deq.poll());
        }
    }
}
