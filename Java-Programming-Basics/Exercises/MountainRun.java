import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double recordInSeconds = Double.parseDouble(scan.nextLine());
        double distanceInMetres = Double.parseDouble(scan.nextLine());
        double timeForOneMeter = Double.parseDouble(scan.nextLine());

        double distanceToClimb = distanceInMetres * timeForOneMeter;
        double distanceOff = Math.floor(distanceInMetres / 50) * 30;
        double wholeDistance = distanceToClimb + distanceOff;

        if (recordInSeconds <= wholeDistance) {
            double recordOff = wholeDistance - recordInSeconds;
            System.out.printf("No! He was %.2f seconds slower.", recordOff);
        }else{
            System.out.printf("Yes! The new record is %.2f seconds.", wholeDistance);
        }
    }
}
