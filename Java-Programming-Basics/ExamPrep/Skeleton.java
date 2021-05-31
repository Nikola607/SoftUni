import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gateMinutes = Integer.parseInt(scan.nextLine());
        int gateSeconds = Integer.parseInt(scan.nextLine());
        double distanceInMetres = Double.parseDouble(scan.nextLine());
        int secondsPer100 = Integer.parseInt(scan.nextLine());

        double wholeGateSeconds = gateMinutes * 60 + gateSeconds;
        double timeMinus = (distanceInMetres / 120) * 2.5;
        double marinTime = (distanceInMetres / 100) * secondsPer100 - timeMinus;
        if (marinTime <= wholeGateSeconds) {
            System.out.printf("Marin Bangiev won an Olympic quota!\n");
            System.out.printf("His time is %.3f.", marinTime);
        } else {
            double timeNeeded = marinTime - wholeGateSeconds;
            System.out.printf("No, Marin failed! He was %.3f second slower.", timeNeeded);
        }
    }
}
