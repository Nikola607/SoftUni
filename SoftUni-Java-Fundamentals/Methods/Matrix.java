import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printMatrix(n);
    }

    private static void printMatrix(int n) {
        int counter = 1;
        for(int i = 0; i<n; i++){
            while(counter<=n){
                System.out.print(n + " ");
                counter++;
            }
            System.out.println();
            counter = 1;
        }
    }
}
