import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double food = Double.parseDouble(scan.nextLine());
        double totalDogFood = 0;
        double totalCatFood = 0;
        double biscuits = 0;

        for (int i = 1; i <= days; i++) {
            int dogFoodEaten = Integer.parseInt(scan.nextLine());
            int catFoodEaten = Integer.parseInt(scan.nextLine());
            totalDogFood += dogFoodEaten;
            totalCatFood += catFoodEaten;
            if (i % 3 == 0) {
                biscuits += (dogFoodEaten + catFoodEaten) * 0.1;
            }
        }
        double totalFoodEaten = totalCatFood + totalDogFood;

        System.out.printf("Total eaten biscuits: %dgr.\n", Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.\n", totalFoodEaten * 1.0 / food * 100);
        System.out.printf("%.2f%% eaten from the dog.\n", totalDogFood * 1.0 / totalFoodEaten * 100);
        System.out.printf("%.2f%% eaten from the cat.", totalCatFood * 1.0 / totalFoodEaten * 100);
    }
}