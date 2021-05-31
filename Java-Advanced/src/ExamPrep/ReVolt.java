package ExamPrep;

import java.util.Scanner;

public class ReVolt {

    static int playerRow;
    static int playerCol;
    static String lastCommand;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();

            matrix[i] = line.toCharArray();

            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf("f");
            }
        }

        boolean finished = false;


        while (n-- > 0 && !finished) {
            String command = scan.nextLine();

            switch (command) {
                case "left":
                    lastCommand = "left";
                    finished = move(playerRow, playerCol - 1, matrix);
                    break;
                case "right":
                    lastCommand = "right";
                    finished = move(playerRow, playerCol + 1, matrix);
                    break;
                case "up":
                    lastCommand = "up";
                    finished = move(playerRow - 1, playerCol, matrix);
                    break;
                case "down":
                    lastCommand = "down";
                    finished = move(playerRow + 1, playerCol, matrix);
                    break;
            }
            printMatrix(matrix);
            System.out.println();
        }

        String message = finished ?
                "Player won!" :
                "Player lost!";

        System.out.println(message);
        printMatrix(matrix);
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';

        if (!isInBounds(newRow, newCol, matrix)) {
            boolean isFixed = false;
            if (newRow < 0) {
                playerRow = matrix.length - 1;
                newRow = matrix.length - 1;
                isFixed = true;
            } else if (newRow > matrix.length - 1) {
                isFixed = true;
                playerRow = 0;
                newRow = 0;
            }

            if (!isFixed) {
                if (newCol < 0) {
                    playerCol = matrix[newRow].length - 1;
                    newCol = matrix[newRow].length - 1;
                } else if (newCol > matrix[newRow].length - 1) {
                    playerCol = 0;
                    newCol = 0;
                }
            }

        }

        char symbol = matrix[newRow][newCol];
        if (symbol == 'F') {
            matrix[newRow][newCol] = 'f';
            return true;
        } else if (symbol == 'B') {
            switch (lastCommand) {
                case "left":
                    move(playerRow, playerCol - 2, matrix);
                    break;
                case "right":
                    move(playerRow, playerCol + 2, matrix);
                    break;
                case "up":
                    move(playerRow - 2, playerCol, matrix);
                    break;
                case "down":
                    move(playerRow + 2, playerCol, matrix);
                    break;
            }
        } else if (symbol == 'T') {
            move(playerRow, playerCol, matrix);
        } else {

            matrix[newRow][newCol] = 'f';
            playerRow = newRow;
            playerCol = newCol;
        }

        return false;
    }
}
