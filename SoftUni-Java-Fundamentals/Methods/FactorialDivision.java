import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int firstFactorial = printFirst(num1);
        int secondFactorial = printSecond(num2);
        if(firstFactorial>secondFactorial){
            System.out.printf("%.2f", (double)firstFactorial/secondFactorial);
        }else{
            System.out.printf("%.2f", (double)secondFactorial/firstFactorial);
        }
    }

    private static int printSecond(int num2) {
        int sum = 1;
        for(int i = num2;i>=1; i--){
            sum *=i;
        }
        return sum;
    }

    private static int printFirst(int num1) {
        int sum = 1;
        for(int i = num1;i>=1; i--){
            sum *=i;
        }
        return sum;
    }
}
