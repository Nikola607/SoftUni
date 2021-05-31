package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deq = new ArrayDeque<>();
        String input = scan.nextLine();

        String current = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!deq.isEmpty()) {
                    current = deq.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }

            } else {
                if (!current.equals("")) {
                    deq.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = scan.nextLine();
        }
    }
}

