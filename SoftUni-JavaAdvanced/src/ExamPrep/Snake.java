package ExamPrep;

import java.util.Scanner;

public class Snake {

    static int food;
    static int snakeRow;
    static int snakeCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }
        }
        boolean escaped = false;

        while (food < 10 && !escaped) {
            String command = scan.nextLine();
            switch (command) {
                case "left":
                    escaped = moveLeft(snakeRow, snakeCol - 1, matrix);
                    break;
                case "right":
                    escaped = moveLeft(snakeRow, snakeCol + 1, matrix);
                    break;
                case "up":
                    escaped = moveLeft(snakeRow - 1, snakeCol, matrix);
                    break;
                case "down":
                    escaped = moveLeft(snakeRow + 1, snakeCol, matrix);
                    break;
            }
        }

        if (escaped) {
            System.out.println("Game over!");
        } else if (food == 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + food);

        printMatrix(matrix);
    }

    private static boolean moveLeft(int newRow, int newCol, char[][] matrix) {
        matrix[snakeRow][snakeCol] = '.';
        if (isOutOfBounds(newRow, newCol, matrix)) {
            return true;
        }

        char symbol = matrix[newRow][newCol];


        if (symbol == '*') {
            food++;
        }

        if (symbol == 'B') {
            matrix[newRow][newCol] = '.';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B') {
                        newRow = row;
                        newCol = col;
                        break;
                    }
                }
                if (matrix[newRow][newCol] == 'B') {
                    break;
                }
            }
        }
        matrix[newRow][newCol] = 'S';

        snakeRow = newRow;
        snakeCol = newCol;

        return false;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
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
