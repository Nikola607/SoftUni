import java.util.Scanner;

public class BackInMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int timeIn30 = minutes + 30;
        if(timeIn30 >59){
            hours++;
            timeIn30-=60;
        }
        if(hours>23){
            hours = 0;
        }
        if(timeIn30<10){
            System.out.printf("%d:0%d",hours, timeIn30 );
        }else {
            System.out.printf("%d:%d", hours, timeIn30);
        }
    }
}
