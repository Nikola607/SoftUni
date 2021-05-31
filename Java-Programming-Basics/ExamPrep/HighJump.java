import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wantedJump = Integer.parseInt(scan.nextLine());
        int starterJump = wantedJump - 30;
        int timesJumped = 0;
        boolean isFailed = false;

        while (starterJump <= wantedJump) {
            for (int i = 0; i < 3; i++) {
                int jumpAtTheMoment = Integer.parseInt(scan.nextLine());
                timesJumped++;
                if (jumpAtTheMoment > starterJump) {
                    starterJump += 5;
                    break;
                }
                if (i == 2) {
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", jumpAtTheMoment, timesJumped);
                    isFailed = true;
                }
            }
            if (isFailed) {
                break;
            }
        }
        if (!isFailed) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", wantedJump, timesJumped);
        }
    }
}
