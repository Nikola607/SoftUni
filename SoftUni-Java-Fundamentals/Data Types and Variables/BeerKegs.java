import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String newBest = "";
        double newBestDouble = 0;

        for (int i = 1; i <= n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double sum = Math.PI * radius * radius * height;
            if (i == 1) {
                newBestDouble = sum;
                newBest = model;
            }else if (sum> newBestDouble) {
                newBestDouble = sum;
                newBest = model;
            }
        }
        System.out.println(newBest);
    }
}
