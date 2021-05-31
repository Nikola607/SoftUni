package Generics.GenericSwapInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        SwapBox<Integer> swapBox = new SwapBox<>();

        while (n-- > 0){
            int input =Integer.parseInt(scan.nextLine());

            swapBox.addElements(input);
        }

        int[] indexToSwap = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int indexOne = indexToSwap[0];
        int indexTwo = indexToSwap[1];

        swapBox.swapElements(indexOne, indexTwo);
        System.out.println(swapBox);
    }
}
