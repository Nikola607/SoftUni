import java.util.Scanner;

public class CharsToStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char num1 = scan.nextLine().charAt(0);
        char num2 = scan.nextLine().charAt(0);
        char num3 = scan.nextLine().charAt(0);
        System.out.printf("%c %c %c", num3, num2, num1);
    }
}
