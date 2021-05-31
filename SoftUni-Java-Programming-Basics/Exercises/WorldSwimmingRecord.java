import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double record = Double.parseDouble(scan.nextLine());
        double distanceMetres = Double.parseDouble(scan.nextLine());
        double timeFor1Meter= Double.parseDouble(scan.nextLine());

        double distanceToSwim = distanceMetres * timeFor1Meter;
        double distance15 = distanceMetres / 15;
        double distanceDown =  Math.floor(distance15);
        double distance = distanceDown * 12.5;
        double wholeDistance = distanceToSwim + distance;

        if (record > wholeDistance){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", wholeDistance);
        }else {
            double neededTime = wholeDistance - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", neededTime);
        }
    }
}
