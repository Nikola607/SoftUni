import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int countFirst = 0;
        int countSecond = 0;
        int countThird = 0;
        int countForth = 0;
        int countFifth = 0;

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(scan.nextLine());
            if (value < 200) {
                countFirst++;
            } else if (value >= 200 && value <= 399) {
                countSecond++;
            } else if (value >= 400 && value <= 599) {
                countThird++;
            } else if (value >= 600 && value <= 799) {
                countForth++;
            } else if (value >=800) {
                countFifth++;
            }
        }
        double firstP = countFirst * 1.0 / n * 100;
        double secondP = countSecond * 1.0 / n * 100;
        double thirdP = countThird * 1.0 / n * 100;
        double forthP = countForth * 1.0 / n * 100;
        double fifthP = countFifth * 1.0 / n * 100;

        System.out.printf("%.2f%%\n", firstP);
        System.out.printf("%.2f%%\n", secondP);
        System.out.printf("%.2f%%\n", thirdP);
        System.out.printf("%.2f%%\n", forthP);
        System.out.printf("%.2f%%", fifthP);
    }
}
