import java.util.Scanner;

public class TimeMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int minutes15 = minutes + 15;
        int minutesNow = minutes15 % 60;
        int hoursNow = hours + (minutes15 / 60);

        if (hours >= 23 & minutes >= 45){
            System.out.printf("0:%02d", minutesNow);
        }else{
            System.out.printf("%d:%02d", hoursNow, minutesNow);
        }
    }
}
