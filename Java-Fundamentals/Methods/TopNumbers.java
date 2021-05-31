import java.util.Scanner;

public class TopNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for(int i = 1; i<=num; i++){
            boolean isDivisible = printIsDivisible(i);
            boolean isOddDigits = printIsOddDigits(i);
            if(isDivisible && isOddDigits){
                System.out.println(i);
            }
        }
    }

    private static boolean printIsOddDigits(int num) {
        int digit = 0;
        while(num>0){
            digit = num%10;
            if(digit%2!=0){
                return true;
            }
            num/=10;
            digit = 0;
        }
        return false;
    }

    private static boolean printIsDivisible(int num) {
        int sum = 0;
        while(num>0){
            sum += num%10;
            num/=10;
        }
            return sum%8==0;
    }
}
