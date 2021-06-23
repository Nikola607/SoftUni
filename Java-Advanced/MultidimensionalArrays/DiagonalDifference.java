package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int [rowsAndCols][rowsAndCols];

        for(int i = 0; i < matrix.length; i++){
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();

            matrix[i] = arr;
        }

        int primarySum = 0;
        int secondarySum = 0;

        for(int row = 0; row<matrix.length; row++){              //Getting the sum of the primary diagonal
            for(int col = 0; col<matrix[row].length; col++){

                if(row == col){
                    primarySum+=matrix[row][col];
                }
            }
        }

        for(int row = matrix.length - 1; row >= 0; row--){              //Getting the sum of the secondary diagonal
            for(int col = 0; col<matrix[row].length; col++){

                if(row + col == matrix.length - 1){
                    secondarySum+=matrix[row][col];
                }
            }
        }

        if(primarySum>secondarySum){
            System.out.println(primarySum - secondarySum);
        }else{
            System.out.println(secondarySum - primarySum);
        }
    }
}
