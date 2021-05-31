import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrOne = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e)).toArray();
        int[] arrTwo = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e)).toArray();
        int sum = 0;
        boolean notIdentical = true;

        for(int i = 0;i< arrOne.length;i++){
            sum+=arrOne[i];
            if(arrOne[i]!=arrTwo[i]){
                notIdentical = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        if(notIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
