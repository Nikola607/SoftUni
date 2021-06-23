package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = getArray(scan);
        int rows = array[0];
        int cols = array[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = getArray(scan);

            matrix[i] = arr;
        }

        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        int[][] bestMatrix = new int[bestRow][bestCol];

        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);
        System.out.println(maxSum);
    }

    private static int[] getArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(", ")).
                mapToInt(Integer::parseInt).toArray();
    }
}


