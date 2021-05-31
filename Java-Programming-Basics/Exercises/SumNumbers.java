
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());
        int nCombination = 0;
        boolean isFound = true;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++){
                nCombination++;
                if(i + j == magicNumber){
                    isFound = false;
                    System.out.printf("Combination N:%d (%d + %d = %d)", nCombination, i, j, magicNumber);
                    break;
                }
            }
            if(!isFound){
                break;
            }
        }
        if(isFound){
            System.out.printf("%d combinations - neither equals %d", nCombination, magicNumber);
        }
    }
}
