import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String sex = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();
        double sum = 0;

        switch (sport) {
            case "Gym":
                switch (sex) {
                    case "m":
                        sum = budget - 42;
                        break;
                    case "f":
                        sum = budget - 35;
                        break;
                }
                break;
            case "Boxing":
                switch (sex) {
                    case "m":
                        sum = budget - 41;
                        break;
                    case "f":
                        sum = budget - 37;
                        break;
                }
                break;
            case "Yoga":
                switch (sex) {
                    case "m":
                        sum = budget - 45;
                        break;
                    case "f":
                        sum = budget - 42;
                        break;
                }
                break;
            case "Zumba":
                switch (sex) {
                    case "m":
                        sum = budget - 34;
                        break;
                    case "f":
                        sum = budget - 31;
                        break;
                }
                break;
            case "Dances":
                switch (sex) {
                    case "m":
                        sum = budget - 51;
                        break;
                    case "f":
                        sum = budget - 53;
                        break;
                }
                break;
            case "Pilates":
                switch (sex) {
                    case "m":
                        sum = budget - 39;
                        break;
                    case "f":
                        sum = budget - 37;
                        break;
                }
                break;
        }
        if (age < 20 ) {
            sum = sum - 0.20 * sum + 4;
        }
        if (sum >= 0) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", Math.abs(sum));
        }
    }
}