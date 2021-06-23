package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = getArray(scan);
        int firstRows = array[0];
        int firstCols = array[1];

        int[][] firstMatrix = new int[firstRows][firstCols];

        readMatrix(scan, firstRows, firstMatrix);

        array = getArray(scan);
        int secondRows = array[0];
        int secondCols = array[1];

        int[][] secondMatrix = new int[secondRows][secondCols];

        readMatrix(scan, secondRows, secondMatrix);

        if (equalMatrix(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static void readMatrix(Scanner scan, int firstRows, int[][] firstMatrix) {
        for (int i = 0; i < firstRows; i++) {
            int[] arr = getArray(scan);

            firstMatrix[i] = arr;
        }
    }

    private static int[] getArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).
                toArray();
    }

    public static boolean equalMatrix(int[][] firstMatrix, int[][] secondMatrix){
        if(firstMatrix.length!=secondMatrix.length){
            return false;
        }
        for(int rows = 0; rows < firstMatrix.length; rows++){
            if(firstMatrix[rows].length!=secondMatrix[rows].length){
                return false;
            }
            for(int cols = 0; cols<firstMatrix[rows].length; cols++){
                if(firstMatrix[rows][cols]!=secondMatrix[rows][cols]){
                    return false;
                }
            }
        }
        return true;
    }
}
