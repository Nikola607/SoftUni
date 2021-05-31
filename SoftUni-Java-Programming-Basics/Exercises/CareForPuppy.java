import java.util.Scanner;

public class CareForPuppy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int foodForDogKg = Integer.parseInt(scan.nextLine());
        int leftFood = 0;
        String command = scan.nextLine();

        while (!command.equals("Adopted")) {
            int foodEaten = Integer.parseInt(command);
            leftFood += foodEaten;
            command = scan.nextLine();
        }

        if (leftFood <= foodForDogKg * 1000) {
            int diff = foodForDogKg * 1000 - leftFood;
            System.out.printf("Food is enough! Leftovers: %d grams.", diff);
        } else {
            int diff = leftFood - foodForDogKg * 1000;
            System.out.printf("Food is not enough. You need %d grams more.", diff);
        }
    }
}
