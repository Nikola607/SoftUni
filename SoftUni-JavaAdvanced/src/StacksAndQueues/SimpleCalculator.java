package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deq = new ArrayDeque<>();
        String[] command = scan.nextLine().split("\\s+");

        Collections.addAll(deq, command);

        while (deq.size() > 1) {
            int firstNum = Integer.parseInt(deq.pop());
            String symbol = deq.pop();
            int secondNum = Integer.parseInt(deq.pop());

            int sum = symbol.equals("+") ?
                    firstNum + secondNum :
                    firstNum - secondNum;
            deq.push(String.valueOf(sum));
        }
        System.out.println(deq.pop());
    }
}
