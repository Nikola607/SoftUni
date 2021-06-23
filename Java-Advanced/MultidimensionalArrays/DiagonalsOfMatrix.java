package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalsOfMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i<rows; i++){
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();

            matrix[i] = arr;
        }

        for(int row = 0; row<matrix.length; row++){               //first diagonal
            for(int col = 0; col<matrix[row].length; col++){

                if(row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }

        System.out.println();

        for(int row = matrix.length - 1; row>=0; row--){
            for(int col = 0; col<matrix[row].length; col++){

                if(row + col == matrix.length - 1){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
