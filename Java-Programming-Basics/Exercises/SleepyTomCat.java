import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int daysOff = Integer.parseInt(scan.nextLine());
        int daysOffPlay = daysOff * 127;
        int daysWork = 365 - daysOff;
        int daysWorkPlay = daysWork * 63;
        int workAndPlay = daysOffPlay + daysWorkPlay;
        if (30000 <= workAndPlay){
            int workAndPlayMinus = workAndPlay - 30000;
            int workAndPlayHours = workAndPlayMinus / 60;
            int workAndPlayMinutes = workAndPlayMinus % 60;
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", workAndPlayHours, workAndPlayMinutes);
        }else {
            int workAndPlayMinus = 30000 - workAndPlay;
            int workAndPlayHours = workAndPlayMinus / 60;
            int workAndPlayMinutes = workAndPlayMinus % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", workAndPlayHours, workAndPlayMinutes);
        }
    }
}
