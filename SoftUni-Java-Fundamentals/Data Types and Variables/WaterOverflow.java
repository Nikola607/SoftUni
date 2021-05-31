import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for(int i =1; i<=n; i++){
            int litres = Integer.parseInt(scan.nextLine());
            sum+=litres;
            if(sum>255){
                sum-=litres;
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(sum);
    }
}
