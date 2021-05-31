import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = first; i <= second; i++) {
            if(i==second){
                System.out.printf("%d\n", first);
                first = i + 1;
                sum+=i;
                break;
            }
            System.out.printf("%d ", first);
            first = i + 1;
            sum+=i;
        }
        System.out.printf("Sum: %d", sum);
    }
}
