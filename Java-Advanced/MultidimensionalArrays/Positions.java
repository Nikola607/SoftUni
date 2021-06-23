package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Positions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                toArray();
        int rows = array[0];
        int cols = array[1];

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i<rows; i++){
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                    toArray();

            matrix[i] = arr;
        }

        int num = Integer.parseInt(scan.nextLine());

        boolean isFound = false;

        for(int row = 0; row<matrix.length;row++){
            for(int col = 0; col<matrix[row].length; col++){
                if(matrix[row][col]==num){
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if(!isFound){
            System.out.println("not found");
        }
    }
}
