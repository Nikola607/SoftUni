import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());;
        int end = Integer.parseInt(scan.nextLine());;

        int firstS = start / 1000;
        int secondS = (start / 100) % 10;
        int thirdS = (start / 10) % 10;
        int fourthS = start % 10;

        int firstE = end / 1000;
        int secondE = (end / 100) % 10;
        int thirdE = (end / 10) % 10;
        int fourthE = end % 10;

        for (int i = firstS; i <= firstE; i++) {
            for (int j = secondS; j <= secondE; j++) {
                for (int k = thirdS; k <= thirdE; k++) {
                    for (int l = fourthS; l <= fourthE; l++) {
                        if (i % 2!= 0 && j % 2 != 0 && k %2 != 0 && l % 2 !=0 ){
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}