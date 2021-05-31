package TextProccesing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numOne = scan.nextLine().replaceFirst("^0+", "");
        int numTwo = Integer.parseInt(scan.nextLine());

        if (numTwo == 0) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        for (int i = numOne.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(numOne.charAt(i)));
            int result = digit * numTwo + carry;

            if (i == 0) {
                sb.insert(0, result);

            } else {
                int resDigit = result % 10;
                carry = result / 10;

                sb.insert(0, resDigit);
            }
        }

        System.out.println(sb);
    }
}
