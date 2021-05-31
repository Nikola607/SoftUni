import java.util.Scanner;

public class SumInSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int wholeTime = first + second + third;

        int timeInMinutes = wholeTime / 60;
        int timeInSeconds = wholeTime % 60;
        if (timeInSeconds < 10){
            System.out.printf("%d:0%d", timeInMinutes, timeInSeconds);
        }else{
            System.out.printf("%d:%d", timeInMinutes, timeInSeconds);
        }
    }
}
