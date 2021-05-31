import java.util.Scanner;

public class MaxNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int max = Integer.MIN_VALUE;

        while (!input.equals("Stop")) {
            int current = Integer.parseInt(input);
            if (current > max) {
                max = current;
            }
            input = scan.nextLine();
        }
        System.out.println(max);
    }
}
