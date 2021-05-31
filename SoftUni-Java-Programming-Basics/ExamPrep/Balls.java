import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int points = 0;

        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int other = 0;
        int ballsCount = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= ballsCount; i++) {
            String colors = scan.nextLine();
            if (colors.equals("red")) {
                red ++;
                points += 5;
            } else if (colors.equals("orange")) {
                orange ++;
                points += 10;
            } else if (colors.equals("yellow")) {
                yellow ++;
                points += 15;
            } else if (colors.equals("white")) {
                white ++;
                points += 20;
            } else if (colors.equals("black")) {
                black++;
                points = points / 2;
            }else{
                other++;
            }
        }
        System.out.printf("Total points: %d\n", points);
        System.out.printf("Points from red balls: %d\n", red);
        System.out.printf("Points from orange balls: %d\n", orange);
        System.out.printf("Points from yellow balls: %d\n", yellow);
        System.out.printf("Points from white balls: %d\n", white);
        System.out.printf("Other colors picked: %d\n", other);
        System.out.printf("Divides from black balls: %d", black);
    }
}