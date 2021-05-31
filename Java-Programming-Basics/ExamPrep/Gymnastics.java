import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();
        String tool = scan.nextLine();
        double points = 0;

        switch (country) {
            case "Russia":
                switch (tool) {
                    case "ribbon":
                        points = 9.100 + 9.400;
                        break;
                    case "hoop":
                        points = 9.300 + 9.800;
                        break;
                    case "rope":
                        points = 9.600 + 9.00;
                        break;
                }
                break;
            case "Bulgaria":
                switch (tool) {
                    case "ribbon":
                        points = 9.600 + 9.400;
                        break;
                    case "hoop":
                        points = 9.550 + 9.750;
                        break;
                    case "rope":
                        points = 9.500 + 9.400;
                        break;
                }
                break;
            case "Italy":
                switch (tool) {
                    case "ribbon":
                        points = 9.200 + 9.500;
                        break;
                    case "hoop":
                        points = 9.450 + 9.350;
                        break;
                    case "rope":
                        points = 9.700 + 9.150;
                        break;
                }
                break;
        }
        System.out.printf("The team of %s get %.3f on %s.\n", country, points, tool);
        double pointsMax = 20 - points;
        double pointsNeeded = (pointsMax / 20) * 100;
        System.out.printf("%.2f%%", pointsNeeded);
    }
}
