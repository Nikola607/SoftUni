import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pensPacket = Integer.parseInt(scan.nextLine());
        int markersPacket = Integer.parseInt(scan.nextLine());
        double cleaningP = Double.parseDouble(scan.nextLine());
        int percentOff = Integer.parseInt(scan.nextLine());

        double wholeSum = (5.80 * pensPacket + 7.20 * markersPacket + 1.20 * cleaningP);
        double finalSum = wholeSum - (wholeSum * percentOff / 100);
        System.out.printf("%.3f", finalSum);
    }
}
