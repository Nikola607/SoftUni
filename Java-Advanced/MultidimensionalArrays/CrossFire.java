package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rowsAndCols[0], rowsAndCols[1]);

        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("Nuke")) {
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);

            nukeMatrix(row, col, power, matrix);
            input = scan.nextLine().split("\\s+");
            matrix.removeIf(List::isEmpty);
        }
        printMatrix(matrix);
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for(List<Integer> integers : matrix){
            for(Integer integer : integers){
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void nukeMatrix(int rows, int cols, int power, List<List<Integer>> matrix) {
        //Vertical line
        for (int row = rows - power; row <= rows + power; row++) {
            if (isInBoundsCols(row, cols, matrix) && row != rows) {
                matrix.get(row).remove(cols);
            }
        }
        //Horizontal line
        for (int col = cols + power; col >= cols - power; col--) {
            if (isInBoundsCols(rows, col, matrix)) {
                matrix.get(rows).remove(col);
            }
        }
    }

    private static boolean isInBoundsCols(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int row, int col) {
        int num = 1;
        for (int rows = 0; rows < row; rows++) {
            matrix.add(new ArrayList<>());
            for (int cols = 0; cols < col; cols++) {
                matrix.get(rows).add(num++);
            }
        }
    }
}
