import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggsOne = Integer.parseInt(scan.nextLine());
        int eggsTwo = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        while (!command.equals("End of battle")) {
            if (command.equals("one")) {
                eggsTwo--;
            } else if (command.equals("two")) {
                eggsOne--;
            }
            if (eggsOne == 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggsTwo);
                break;
            } else if (eggsTwo == 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggsOne);
                break;
            }
            command = scan.nextLine();
        }
        if (command.equals("End of battle")) {
            System.out.printf("Player one has %d eggs left.\n", eggsOne);
            System.out.printf("Player two has %d eggs left.", eggsTwo);
        }
    }
}
