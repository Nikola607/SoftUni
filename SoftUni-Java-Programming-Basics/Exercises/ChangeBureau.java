import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoin = Integer.parseInt(scan.nextLine());
        double china = Double.parseDouble(scan.nextLine());
        double com = Double.parseDouble(scan.nextLine());

        int nBitcoin = bitcoin * 1168;
        double nChina = 0.15 * china;
        double eChina = nChina * 1.76;

        double sum = (nBitcoin + eChina) / 1.95;
        double wholeSum =  sum * com / 100;
        double finalSum = sum - wholeSum;
        System.out.printf("%.2f", finalSum);
    }
}
