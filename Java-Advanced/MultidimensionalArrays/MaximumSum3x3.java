package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum3x3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = getInput(scan);
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = getInput(scan);

            matrix[i] = arr;
        }

        int bestSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int firstLine = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
                int secondLine = matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
                int thirdLine = matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                int sum = firstLine + secondLine + thirdLine;

                if(sum>bestSum){
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1] + " " + matrix[bestRow][bestCol + 2]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1] + " " + matrix[bestRow + 1][bestCol+ 2]);
        System.out.println(matrix[bestRow + 2][bestCol] + " " + matrix[bestRow + 2][bestCol + 1] + " " + matrix[bestRow + 2][bestCol + 2]);
    }

    private static int[] getInput(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }
}
