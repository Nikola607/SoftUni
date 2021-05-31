package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        int rowsAndCols = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[rowsAndCols][rowsAndCols];
        int num = 1;

        if (pattern.equals("A")) {
            FirstPattern(rowsAndCols, matrix, num);
        } else {
            SecondPattern(rowsAndCols, matrix, num);
        }
    }

    private static void SecondPattern(int rowsAndCols, int[][] matrix, int num) {
        for (int cols = 0; cols < rowsAndCols; cols++) {
            if (cols % 2 == 0) {
                for (int rows = 0; rows < matrix.length; rows++) {
                    matrix[rows][cols] = num++;
                }
            } else {
                for (int rows = matrix.length - 1; rows >= 0; rows--) {
                    matrix[rows][cols] = num++;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void FirstPattern(int rowsAndCols, int[][] matrix, int num) {
        for (int cols = 0; cols < rowsAndCols; cols++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix[rows][cols] = num++;
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }
}
