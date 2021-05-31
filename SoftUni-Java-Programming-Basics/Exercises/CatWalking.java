import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutesToWalk = Integer.parseInt(scan.nextLine());
        int walksPerDay = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());

        int timesWalk = minutesToWalk * walksPerDay;
        double caloriesPerDay = timesWalk * 5;
        double percentOff = calories - (calories * 0.5);

        if (caloriesPerDay >= percentOff) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", caloriesPerDay);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", caloriesPerDay);
        }
    }
}
