package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        readMatrix(scan, rows, firstMatrix);

        readMatrix(scan, rows, secondMatrix);

        char[][] thirdMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstSymbol = firstMatrix[row][col];
                char secondSymbol = secondMatrix[row][col];

                thirdMatrix[row][col] = firstSymbol == secondSymbol ? firstSymbol : '*';
            }
        }
        printMatrix(thirdMatrix);

    }

    private static void readMatrix(Scanner scan, int rows, char[][] firstMatrix) {
        for (int i = 0; i < rows; i++) {
            firstMatrix[i] = scan.nextLine().replaceAll(" ", "").
                    toCharArray();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row<matrix.length; row++){
            char[] arr = matrix[row];
            for(int col = 0; col<matrix[row].length; col++){
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }
}
