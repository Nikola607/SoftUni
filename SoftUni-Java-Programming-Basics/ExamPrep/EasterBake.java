import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cakes = Integer.parseInt(scan.nextLine());
        int maxFlour = Integer.MIN_VALUE;
        int maxSugar = Integer.MIN_VALUE;
        double sugarUsedForNow = 0;
        double flourUsedForNow = 0;


        for (int i = 1; i <= cakes; i++) {
            int sugarUsed = Integer.parseInt(scan.nextLine());
            int flourUsed = Integer.parseInt(scan.nextLine());
            sugarUsedForNow += sugarUsed;
            flourUsedForNow += flourUsed;
            if (sugarUsed > maxSugar) {
                maxSugar = sugarUsed;
            }
            if (flourUsed > maxFlour) {
                maxFlour = flourUsed;
            }
        }
        System.out.printf("Sugar: %.0f\n", Math.ceil(sugarUsedForNow / 950));
        System.out.printf("Flour: %.0f\n", Math.ceil(flourUsedForNow / 750));
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxFlour, maxSugar);
    }
}
