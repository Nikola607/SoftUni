import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            printNumbers(i);
        }
        for (int i = n - 1; i >= 1; i--) {
            printNumbers(i);
        }
    }

    static void printNumbers(int n) {
        for(int i = 1; i<=n; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
