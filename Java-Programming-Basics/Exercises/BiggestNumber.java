import java.util.Scanner;

public class BiggestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int max = Integer.MAX_VALUE;

        while (!input.equals("Stop")) {
            int n = Integer.parseInt(input);
            if (n < max) {
               max = n;
            }
            input = scan.nextLine();
        }
        System.out.println(max);
    }
}
