import java.util.Scanner;

public class StringNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int number=firstNumber;
        String nString = firstNumber + "";
        int aloneNum = 0;

        int finalResult = 0;


        for (int i = 0; i < nString.length(); i++) {
            int firstResult = 1;
            aloneNum = number % 10;
            number /= 10;
            for (int j = aloneNum; j > 0; j--) {

                firstResult = firstResult * (j);

            }
            finalResult += firstResult;


        }
        if (finalResult==firstNumber){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
}