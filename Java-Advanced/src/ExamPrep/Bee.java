package ExamPrep;

import java.util.Scanner;

public class Bee {

    static int beeRow;
    static int beeCol;
    static int flowers;
    static String lastCommand;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("B")) {
                beeRow = i;
                beeCol = line.indexOf("B");
            }
        }

        boolean escaped = false;

        while (!escaped) {
            String command = scan.nextLine();

            switch (command) {
                case "left":
                    lastCommand = "left";
                    escaped = move(beeRow, beeCol - 1, matrix);
                    break;
                case "right":
                    lastCommand = "right";
                    escaped = move(beeRow, beeCol + 1, matrix);
                    break;
                case "up":
                    lastCommand = "up";
                    escaped = move(beeRow - 1, beeCol, matrix);
                    break;
                case "down":
                    lastCommand = "down";
                    escaped = move(beeRow + 1, beeCol, matrix);
                    break;
            }
            if(command.equals("End")){
                break;
            }
        }

        if (escaped) {
            System.out.println("The bee got lost!");
        }

        String message = flowers >= 5 ?
                "Great job, the bee manage to pollinate " + flowers + " flowers!" :
               String.format("The bee couldn't pollinate the flowers, she needed %s flowers more", 5 - flowers);

        System.out.println(message);
        printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[beeRow][beeCol] = '.';

        if (!isInBounds(newRow, newCol, matrix)) {
            return true;
        }
        char symbol = matrix[newRow][newCol];

        if (symbol == 'f') {
            flowers++;
        }

        if (symbol == 'O') {
            matrix[newRow][newCol] = '.';
            switch (lastCommand) {
                case "left":
                    move(beeRow, beeCol - 2, matrix);
                    break;
                case "right":
                    move(beeRow, beeCol + 2, matrix);
                    break;
                case "up":
                    move(beeRow - 2, beeCol, matrix);
                    break;
                case "down":
                    move(beeRow + 2, beeCol, matrix);
                    break;
            }
        }else {

            matrix[newRow][newCol] = 'B';
            beeRow = newRow;
            beeCol = newCol;
        }

        return false;
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
}
