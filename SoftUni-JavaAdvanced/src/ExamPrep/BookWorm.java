package ExamPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BookWorm {

    static int playerRow;
    static int playerCol;
    static ArrayDeque<Character> word = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String givenWord = scan.nextLine();
        for (int j = 0; j < givenWord.length(); j++) {
            char currentSymbol = givenWord.charAt(j);

            word.push(currentSymbol);
        }

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();

            matrix[i] = line.toCharArray();

            if (line.contains("P")) {
                playerRow = i;
                playerCol = line.indexOf("P");
            }
        }

        String command = scan.nextLine();
        boolean escaped = false;

        while (!command.equals("end")) {
            switch (command) {
                case "left":
                    escaped = move(playerRow, playerCol - 1, matrix);
                    break;
                case "right":
                    escaped = move(playerRow, playerCol + 1, matrix);
                    break;
                case "up":
                    escaped = move(playerRow - 1, playerCol, matrix);
                    break;
                case "down":
                    escaped = move(playerRow + 1, playerCol, matrix);
                    break;
            }
            command = scan.nextLine();
        }

        while (!word.isEmpty()){
            System.out.print(word.pollLast());
        }
        System.out.println();
        printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {

        if(!isInBounds(newRow, newCol, matrix)){
            word.poll();
            return true;
        }

        char symbol = matrix[newRow][newCol];

        matrix[playerRow][playerCol] = '-';
        if(Character.isLetter(symbol)){
            word.push(symbol);
        }

        matrix[newRow][newCol] = 'P';
        playerRow = newRow;
        playerCol = newCol;

        return false;
    }

    private static boolean isInBounds(int newRow, int newCol, char[][] matrix) {
        return newRow >=0 && newRow<matrix.length && newCol>=0 && newCol < matrix[newRow].length;
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
