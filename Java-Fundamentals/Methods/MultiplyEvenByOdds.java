import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if(n<0){
            n = Math.abs(n);
        }
        printGetMultipleOfEvenAndOdd(n);
    }

    private static void printGetMultipleOfEvenAndOdd(int n) {
        int evenSum = 0;
        int oddSum = 0;
        int digit = 0;
        while(n>0){
            digit = n%10;
            if(digit%2==0){
                evenSum+=digit;
            }else{
                oddSum+=digit;
            }
            n/=10;
            digit=0;
        }
        System.out.println(evenSum * oddSum);
    }
}
