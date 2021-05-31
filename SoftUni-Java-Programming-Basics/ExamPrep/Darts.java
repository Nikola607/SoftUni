import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String command = scan.nextLine();
        int wholePoints = 301;
        int unsuccessfulShots = 0;
        int successfulShots = 0;

        while (!command.equals("Retire")) {
            int points = Integer.parseInt(scan.nextLine());
            switch (command) {
                case "Single":
                    points *= 1;
                    successfulShots++;
                    break;
                case "Double":
                    points *= 2;
                    successfulShots++;
                    break;
                case "Triple":
                    points *= 3;
                    successfulShots++;
                    break;
            }
            wholePoints -= points;
            if (wholePoints == 0) {
                System.out.printf("%s won the leg with %d shots.", name, successfulShots);
                break;
            } else if (wholePoints < 0) {
                wholePoints += points;
                unsuccessfulShots++;
                successfulShots--;
            }
            command = scan.nextLine();
        }if(command.equals("Retire")) {
            System.out.printf("%s retired after %d unsuccessful shots.", name, unsuccessfulShots);
        }
    }
}