import java.util.Scanner;

public class PrintASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());

        while(start<=end){
            char symbol = (char) (start++);
            System.out.print(symbol + " ");
        }
    }
}
