package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] arr = scan.nextLine().split("\\s+");

            matrix[i] = arr;
        }

        String[] commands = scan.nextLine().split("\\s+");

        while (!commands[0].equals("END")) {
            switch (commands[0]) {
                case "swap":
                    if(commands.length!=5){
                        System.out.println("Invalid input!");
                        break;
                    }
                    int row1 = Integer.parseInt(commands[1]);
                    int col1 = Integer.parseInt(commands[2]);

                    int row2 = Integer.parseInt(commands[3]);
                    int col2 = Integer.parseInt(commands[4]);

                    if (checkIfValid(row1, col1, row2, col2, matrix)) {
                        swapElements(row1, col1, row2, col2, matrix);
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            commands = scan.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }

    private static void swapElements(int row1, int col1, int row2, int col2, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (row == row1 && col == col1) {
                    String firstElement = matrix[row][col];
                    String secondElement = matrix[row2][col2];

                    matrix[row2][col2] = firstElement;
                    matrix[row][col] = secondElement;
                }
            }
        }
    }

    private static boolean checkIfValid(int row1, int col1, int row2, int col2, String[][] matrix) {
        if (row1 >= 0 && row1 < matrix.length && col1 >= 0 && col1 < matrix[row1].length &&
                row2 >= 0 && row2 < matrix.length && col2 >= 0 && col2 < matrix[row2].length) {
            return true;
        }
        return false;
    }
}
