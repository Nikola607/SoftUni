import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tournamentName = scan.nextLine();
        int gamesWon = 0;
        int gamesLost = 0;
        double rounds = 0;

        while(!tournamentName.equals("End of tournaments")) {
            int roundsPerTournament = Integer.parseInt(scan.nextLine());
            for (int i = 1; i <= roundsPerTournament; i++) {
                int pointsHome = Integer.parseInt(scan.nextLine());
                int pointsOut = Integer.parseInt(scan.nextLine());
                if (pointsHome > pointsOut) {
                    gamesWon++;
                    System.out.printf("Game %d of tournament %s: win with %d points.\n", i, tournamentName, pointsHome - pointsOut);
                } else {
                    gamesLost++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.\n", i, tournamentName, pointsOut - pointsHome);
                }
            }
            rounds += roundsPerTournament;
            tournamentName = scan.nextLine();
        }
            System.out.printf("%.2f%% matches win\n", gamesWon * 1.0 / rounds * 100);
            System.out.printf("%.2f%% matches lost", gamesLost * 1.0 / rounds * 100);
    }
}
