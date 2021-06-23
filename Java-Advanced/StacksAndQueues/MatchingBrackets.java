package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                deq.push(i);
            } else if (currentSymbol == ')') {
                int startIndex = deq.pop();
                String contest = input.substring(startIndex, i + 1);
                System.out.println(contest);
            }
        }
    }
}
