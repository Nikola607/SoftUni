package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= size; i++) {
            printRow(size, i);
        }

        for (int j = size - 1; j >= 1; j--) {
            printRow(size, j);
        }
    }

    private static void printRow(int size, int i) {
        for (int k = 0; k < size - i; k++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
