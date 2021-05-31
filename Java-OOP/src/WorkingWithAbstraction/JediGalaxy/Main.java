package WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static long sum = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] size = readArray(scan);

        int[][] matrix = new int[size[0]][size[1]];
        fillMatrix(matrix);

        String[] input = scan.nextLine().split("\\s+");
        while (!input[0].equals("Let")) {
            int jediRow = Integer.parseInt(input[0]);
            int jediCol = Integer.parseInt(input[1]);

            int[] evilRowAndCol = readArray(scan);

            int evilRow = evilRowAndCol[0];
            int evilCol = evilRowAndCol[1];

            moveEvil(evilRow, evilCol, matrix);
            moveJedi(jediRow, jediCol, matrix);

            input = scan.nextLine().split("\\s+");
        }
        System.out.println(sum);
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }

    private static void moveJedi(int jediRow, int jediCol, int[][] matrix) {
        while (jediRow >= 0 && jediCol < matrix[0].length) {
            if (isInBounds(jediRow, jediCol, matrix)) {
                sum += matrix[jediRow][jediCol];
            }
            jediRow--;
            jediCol++;
        }
    }

    private static void moveEvil(int evilRow, int evilCol, int[][] matrix) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isInBounds(evilRow, evilCol, matrix)) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void fillMatrix(int[][] matrix) {
        int num = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = num;
                num++;
            }
        }
    }
}
