import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cake = Integer.parseInt(scan.nextLine());
        int eggs = Integer.parseInt(scan.nextLine());
        int biscuits = Integer.parseInt(scan.nextLine());

        double paintedEggs = eggs * 12 * 0.15;
        double wholeSum = (cake * 3.20) + eggs * 4.35 + (biscuits * 5.40) + paintedEggs;
        System.out.printf("%.2f", wholeSum);
    }
}
