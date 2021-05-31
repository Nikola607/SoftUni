import java.util.Scanner;

public class BackToTheFuture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      double money = Double.parseDouble(scan.nextLine());
        int yearToLiveTo = Integer.parseInt(scan.nextLine());
        int age = 18;
        double moneyLeft = 0;
        int timesLooped = 0;
        for(int i = 1800; i<=yearToLiveTo; i++){
            if(timesLooped==0){
                moneyLeft = money - 12000;
            }
              else if(i%2==0){
                moneyLeft = moneyLeft - 12000;
            }
            else{
                moneyLeft = moneyLeft - (12000  + 50 * age);
            }
            age++;
            timesLooped++;
        }
        if(moneyLeft>=0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        }else{
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(moneyLeft));
        }
    }
}
