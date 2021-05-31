import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstTime = Integer.parseInt(scan.nextLine());
        int secondTime = Integer.parseInt(scan.nextLine());
        int thirdTime = Integer.parseInt(scan.nextLine());

        int totalTimeSeconds = firstTime + secondTime + thirdTime;
        int timeMinutes = totalTimeSeconds / 60;
        int timeInSeconds = totalTimeSeconds % 60;

        if (timeInSeconds < 10 ){
            System.out.println(timeMinutes + ":0" + timeInSeconds);
        }else {
            System.out.println(timeMinutes + ":" + timeInSeconds);
        }

    }
}
