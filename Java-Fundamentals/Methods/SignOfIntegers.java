import java.util.Scanner;

public class SignOfIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printMethod(n);
    }

    private static void printMethod(int n) {
        if(n>0){
            System.out.printf("The number %d is positive.", n);
        }else if(n<0){
            System.out.printf("The number %d is negative.", n);
        }else{
            System.out.printf("The number %d is zero.", n);
        }
    }
}
