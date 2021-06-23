package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        try{
            int num = Integer.parseInt(scan.nextLine());
            System.out.println(Math.pow(num, 2.0));
        }catch (NumberFormatException e){
            System.out.println("Invalid number " + e.getMessage());
        }finally {
            System.out.println("Good bye");
        }
    }
}
