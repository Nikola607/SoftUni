
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        for (int i = num1; i <= num2; i++) {
            int dig1 = i / 100000;
            int dig2 = i / 10000 % 10;
            int dig3 = i / 1000 % 10;
            int dig4 = i / 100 % 10;
            int dig5 = i / 10 % 10;
            int dig6 = i % 10;

            int evenDig = dig2 + dig4 + dig6;
            int oddDig = dig1 + dig3 + dig5;
            if(evenDig == oddDig){
                System.out.println(i);
            }
        }
    }
}
