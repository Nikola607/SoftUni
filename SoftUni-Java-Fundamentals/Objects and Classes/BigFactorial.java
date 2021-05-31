package Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigInteger sum = BigInteger.ONE;

        for(int i = n; i>0; i--){
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.println(sum);
    }
}
