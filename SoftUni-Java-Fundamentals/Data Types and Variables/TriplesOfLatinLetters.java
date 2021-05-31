import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 'a'; i < 'a' + n; i++) {
            for (int j = 'a'; j < 'a' + n; j++) {
                for (int h = 'a'; h < 'a' + n; h++) {
                    System.out.printf("%c%c%c\n", i, j, h);
                }
            }
        }
    }
}
