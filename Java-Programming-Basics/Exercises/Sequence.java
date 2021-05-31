import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int numbers = 1;
        while (numbers <= n) {
            System.out.println(numbers);
            numbers = (numbers * 2) + 1;
        }
    }
}
