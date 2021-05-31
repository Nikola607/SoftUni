import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char symbol = scan.nextLine().charAt(0);
       if(symbol == Character.toLowerCase(symbol)){
           System.out.println("lower-case");
       }else{
           System.out.println("upper-case");
       }
    }
}
