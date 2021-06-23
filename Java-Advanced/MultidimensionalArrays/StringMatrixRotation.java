package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("[()]");
        int degrees = Integer.parseInt(input[1]) % 360;

        String text = scan.nextLine();

        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        int maxLength = 0;
        while (!"END".equals(text)) {
            inputQueue.offer(text);
            if (text.length() > maxLength) {
                maxLength = text.length();
            }
            text = scan.nextLine();
        }

        char[][] charArr = new char[inputQueue.size()][maxLength];
        for (int i = 0; i < charArr.length; i++) {
            String row = inputQueue.poll();
            for (int j = 0; j < maxLength; j++) {
                if (row != null && j < row.length()) {
                    charArr[i][j] = row.charAt(j);
                } else {
                    charArr[i][j] = ' ';
                }
            }
        }

        if(degrees == 0){
            rotation0(charArr);
        }else if(degrees == 90){
            rotation90(charArr);
        }else if(degrees == 180){
            rotation180(charArr);
        }else if(degrees == 270){
            rotation270(charArr);
        }
    }

    private static void rotation270(char[][] charArr) {
        for(int col = charArr[0].length - 1; col>=0; col--){
            for(int row = 0; row<charArr.length; row++){
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotation180(char[][] charArr) {
        for(int row = charArr.length - 1; row>=0; row--){
            for(int col = charArr[0].length - 1; col>=0; col--){
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotation90(char[][] charArr) {
        for(int col = 0; col<charArr[0].length; col++){
            for (int row = charArr.length - 1; row>=0; row--) {
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotation0(char[][] charArr) {
        for(int row = 0; row<charArr.length; row++){
            for(int col = 0; col<charArr[row].length; col++){
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }
}
