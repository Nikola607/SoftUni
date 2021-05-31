import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 1111; i <= 9999; i++) {
            int dig1 = i / 1000;
            int dig2 = i / 100 % 10;
            int dig3 = i / 10 % 10;
            int dig4 = i % 10;
            boolean check1 = (dig1 != 0 && number % dig1 == 0);
            boolean check2 = (dig2 != 0 && number % dig2 == 0);
            boolean check3 = (dig3 != 0 && number % dig3 == 0);
            boolean check4 = (dig4 != 0 && number % dig4 == 0);
            if (check1 && check2 && check3 && check4) {
                System.out.print(i + " ");
            }
        }
    }
}
