import java.util.Scanner;

public class ZigZagArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = Integer.parseInt(scan.nextLine());
        int[] arrOne = new int[numbers];
        int[] arrTwo = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            String[] line = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                arrOne[i] = Integer.parseInt(line[0]);
                arrTwo[i] = Integer.parseInt(line[1]);
            } else {
                arrOne[i] = Integer.parseInt(line[1]);
                arrTwo[i] = Integer.parseInt(line[0]);
            }
        }
        for (int i : arrOne) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int value : arrTwo) {
            System.out.print(value + " ");
        }
    }
}
