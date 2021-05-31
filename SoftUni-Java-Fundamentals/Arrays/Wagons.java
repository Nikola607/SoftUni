import java.util.Scanner;

public class Wagons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int[] trains = new int[wagons];
        int people = 0;

        for (int i = 0; i < wagons; i++) {
            trains[i] = Integer.parseInt(scan.nextLine());
            people += trains[i];
        }
        for (int i = 0; i < trains.length; i++) {
            System.out.print(trains[i] + " ");
        }
        System.out.println();
            System.out.println(people);
    }
}
