import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination =scan.nextLine();
        String dates = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double sum = 0;

        switch(destination){
            case"France":
                switch(dates){
                    case"21-23":
                        sum = 30 * nights;
                        break;
                    case"24-27":
                        sum = 35 * nights;
                        break;
                    case"28-31":
                        sum = 40 * nights;
                        break;
                }
                break;
            case"Italy":
                switch(dates){
                    case"21-23":
                        sum = 28 * nights;
                        break;
                    case"24-27":
                        sum = 32 * nights;
                        break;
                    case"28-31":
                        sum = 39 * nights;
                        break;
                }
                break;
            case"Germany":
                switch(dates){
                    case"21-23":
                        sum = 32 * nights;
                        break;
                    case"24-27":
                        sum = 37 * nights;
                        break;
                    case"28-31":
                        sum = 43 * nights;
                        break;
                }
                break;
        }
        System.out.printf("Easter trip to %s : %.2f leva.", destination, sum);
    }
}
