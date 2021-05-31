import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] wagons = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            wagons[i] = Integer.parseInt(scan.nextLine());
            sum += wagons[i];
        }
        for (int i = 0; i < wagons.length; i++) {
            System.out.print(wagons[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
