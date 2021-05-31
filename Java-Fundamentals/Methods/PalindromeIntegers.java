import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        while(!command.equals("END")){
            int num = Integer.parseInt(command);
            int reversed = printReversedInteger(num);
            if(reversed==num){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
            command = scan.nextLine();
        }
    }

    private static int printReversedInteger(int num) {
        int reversed = 0;
        while(num!=0){
            reversed*=10;
            reversed+=num%10;
            num/=10;
        }
        return reversed;
    }
}
