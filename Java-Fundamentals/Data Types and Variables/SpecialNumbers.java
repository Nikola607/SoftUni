import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for(int i = 1; i<=num; i++){
            i = i / 10;
            sum = sum + i % 10;
            if(sum==5||sum==7||sum==11){
                System.out.println(i + "->" + "True");
            }else{
                System.out.println(i + "->" + "False");
            }
        }
    }
}
