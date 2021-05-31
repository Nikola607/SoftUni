import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startHour = Integer.parseInt(scan.nextLine());
        int startMinutes = Integer.parseInt(scan.nextLine());

        int startTimeMinutes = startHour * 60 + startMinutes;
        int timeAfter15minutes = startTimeMinutes + 15;
        //%02d важно!
        //Math ceil - загръгля на горе
        //Math flor - закръгля на долу
        //double delayTime = Math.floor distance / 15 /пример/
    }
}
