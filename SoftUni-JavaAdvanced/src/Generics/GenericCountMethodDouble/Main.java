package Generics.GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Double> box = new Box<>();

        while (n-- > 0){
            double number = Double.parseDouble(scan.nextLine());

            box.addElements(number);
        }
        double element = Double.parseDouble(scan.nextLine());

        box.compare(element);
        System.out.println(box.compare(element));
    }
}
