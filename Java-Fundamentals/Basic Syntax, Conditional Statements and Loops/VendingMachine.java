import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        double sum = 0;

        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            }else{
                System.out.printf("Cannot accept %.2f\n", coins);
            }
            command = scan.nextLine();
        }
        command = scan.nextLine();
        while(!command.equals("End")){
            switch(command){
                case"Nuts":
                    sum-=2;
                    if(sum>=0){
                        System.out.println("Purchased Nuts");
                    }else{
                        sum+=2;
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case"Water":
                    sum-=0.7;
                    if(sum>=0){
                        System.out.println("Purchased Water");
                    }else{
                        sum+=0.7;
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case"Crisps":
                    sum-=1.5;
                    if(sum>=0){
                        System.out.println("Purchased Crisps");
                    }else{
                        sum+=1.5;
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case"Soda":
                    sum-=0.8;
                    if(sum>=0){
                        System.out.println("Purchased Soda");
                    }else{
                        sum+=0.8;
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case"Coke":
                    sum-=1;
                    if(sum>=0){
                        System.out.println("Purchased Coke");
                    }else{
                        sum+=1;
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            command = scan.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}