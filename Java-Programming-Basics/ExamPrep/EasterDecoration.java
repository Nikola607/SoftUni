import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int clients = Integer.parseInt(scan.nextLine());
        double sum = 0;
        int numbersOfProducts = 0;
        double wholeSum = 0;

        for (int i = 1; i <= clients; i++) {
            sum = 0;
            numbersOfProducts = 0;
            String command = scan.nextLine();
            while (!command.equals("Finish")) {
                switch (command) {
                    case "basket":
                        sum += 1.50;
                        numbersOfProducts++;
                        break;
                    case "wreath":
                        sum += 3.80;
                        numbersOfProducts++;
                        break;
                    case "chocolate bunny":
                        sum += 7;
                        numbersOfProducts++;
                        break;
                }
                command = scan.nextLine();
            }
            if(numbersOfProducts %2==0){
                sum = sum - sum * 0.2;
            }
            wholeSum += sum;
            System.out.printf("You purchased %d items for %.2f leva.\n", numbersOfProducts, sum);
        }
        double averageSum = wholeSum / clients;
        System.out.printf("Average bill per client is: %.2f leva.", averageSum);
    }
}
