import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCakes = Integer.parseInt(scan.nextLine());
        String bestCooker = "";
        int bestPoints = 0;

        for(int i = 1; i<=numberOfCakes; i++) {
            String cooker = scan.nextLine();
            int points = 0;
            String command = scan.nextLine();
            while (!command.equals("Stop")) {
                int grade = Integer.parseInt(command);
                points += grade;
                command = scan.nextLine();
            }
            System.out.printf("%s has %d points.\n", cooker, points);
            if (points > bestPoints) {
                bestPoints = points;
                bestCooker = cooker;
                System.out.printf("%s is the new number 1!\n", cooker);
            }
        }
        System.out.printf("%s won competition with %d points!",bestCooker,  bestPoints);
    }
}
