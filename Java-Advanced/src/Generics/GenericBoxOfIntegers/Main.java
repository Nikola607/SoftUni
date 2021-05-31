package Generics.GenericBoxOfIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Integer> box = new Box<>();

        while (n-- > 0) {
            int input =Integer.parseInt(scan.nextLine());

            box.addElement(input);
        }
        System.out.println(box);
    }
}
