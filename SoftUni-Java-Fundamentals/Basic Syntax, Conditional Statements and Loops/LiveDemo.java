package Bg.SoftUni.Fundamentals;

import java.util.Scanner;

public class LiveDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int NUM1 = scan.nextInt();
        scan.nextLine();
        int NUM2 = Integer.parseInt(scan.nextLine());;
        System.out.println(NUM1);
        System.out.println(NUM2);
        System.out.println(NUM1+NUM2);
    }
}
