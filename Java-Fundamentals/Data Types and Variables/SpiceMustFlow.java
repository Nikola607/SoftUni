import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startingYield = Integer.parseInt(scan.nextLine());
        int total = 0;
        int days = 0;

        while (startingYield >0) {
            if (startingYield < 100) {
                if(total<26){
                    break;
                }
                total -=26;
                break;
            }
            total += startingYield - 26;
            startingYield -= 10;
            days++;
        }
        System.out.println(days);
        System.out.print(total);
    }
}
