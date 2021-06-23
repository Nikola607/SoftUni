package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = getArray(scan);
        int rows = array[0];
        int cols = array[1];

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i<rows; i++){
            int[] arr = getArray(scan);

            matrix[i] = arr;
        }

        int sum = 0;

        for(int row = 0; row<rows; row++){
            for(int col = 0; col<cols; col++){
                sum+=matrix[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[] getArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(", ")).
                mapToInt(Integer::parseInt).toArray();
    }
}
