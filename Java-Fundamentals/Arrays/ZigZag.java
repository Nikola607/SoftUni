import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = Integer.parseInt(line[0]);
                secondArr[i] = Integer.parseInt(line[1]);
            } else {
                firstArr[i] = Integer.parseInt(line[1]);
                secondArr[i] = Integer.parseInt(line[0]);
            }
        }
        for (int value : firstArr) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int value : secondArr) {
            System.out.print(value + " ");
        }
    }
}
