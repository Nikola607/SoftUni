import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double wholePlace = Double.parseDouble(scan.nextLine());
        double sum = 0;
        int timesLoaded = 0;
        int timesLooped = 0;
        String command = scan.nextLine();
        boolean isEnough = true;

        while (!command.equals("End")) {
            double suitcasePlace = Double.parseDouble(command);
            timesLooped++;
            if (timesLooped % 3 == 0) {
                suitcasePlace = suitcasePlace + suitcasePlace * 0.1;
            }
            sum += suitcasePlace;
            if (sum > wholePlace) {
                isEnough = false;
                break;
            }
            timesLoaded++;
            command = scan.nextLine();
        }
        if (!isEnough) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", timesLoaded);
    }
}


