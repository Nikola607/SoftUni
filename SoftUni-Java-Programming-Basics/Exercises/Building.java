import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int levels = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        for (int level = levels; level >= 1; level--) {
            for (int room = 0; room < rooms; room++) {
                if (level == levels) {
                    System.out.printf("L%d%d ", level, room);
                } else if (level % 2 == 0) {
                    System.out.printf("O%d%d ", level, room);
                } else  {
                    System.out.printf("A%d%d ", level, room);
                }
            }
            System.out.println();
        }
    }
}
