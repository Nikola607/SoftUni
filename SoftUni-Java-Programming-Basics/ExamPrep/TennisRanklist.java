import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int playedTournaments = Integer.parseInt(scan.nextLine());
        int starterPoints = Integer.parseInt(scan.nextLine());
        int timesWon = 0;
        int pointsWon = 0;

        for (int i = 1; i <= playedTournaments; i++) {
            String action = scan.nextLine();
            if (action.equals("W")) {
                starterPoints += 2000;
                pointsWon +=2000;
                timesWon++;
            } else if (action.equals("F")) {
                starterPoints += 1200;
                pointsWon +=1200;
            } else if (action.equals("SF")) {
                starterPoints += 720;
                pointsWon +=720;
            }
        }
        int averagePoints = pointsWon  / playedTournaments;
        System.out.printf("Final points: %d\n", starterPoints);
        System.out.printf("Average points: %d\n", averagePoints);
        System.out.printf("%.2f%%", timesWon * 1.0 / playedTournaments * 100);
    }
}
