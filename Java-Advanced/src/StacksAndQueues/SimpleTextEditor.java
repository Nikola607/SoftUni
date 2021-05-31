package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> deq = new ArrayDeque<>();
        String string = "";

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split(" ");

            switch (commands[0]) {
                case "1":
                    deq.push(string);
                    string += commands[1] ;
                    break;
                case "2":
                    deq.push(string);
                    int eraseElements = Integer.parseInt(commands[1]);
                    string = string.substring(0, string.length() - eraseElements);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(string.charAt(index - 1));
                    break;
                case "4":
                    string = deq.pop();
                    break;
            }
        }
    }
}
