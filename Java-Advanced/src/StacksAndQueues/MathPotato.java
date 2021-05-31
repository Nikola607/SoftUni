package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deq = Arrays.stream(scan.nextLine().
                split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        int num = Integer.parseInt(scan.nextLine());

        int cycle = 1;

        while (deq.size() > 1) {
            for (int i = 1; i < num; i++) {
                deq.offer(deq.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + deq.peek());
            }else{
                System.out.println("Removed " + deq.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + deq.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2; i++) {
            if (cycle % i == 0){
                return false;
            }
        }
        return true;
    }
}
