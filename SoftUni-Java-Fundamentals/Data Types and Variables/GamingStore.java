import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = Double.parseDouble(scan.nextLine());
        boolean gameTime = false;
        double lastGameBought = 0;
        double balanceLeft = balance;
        boolean gameHere = false;

        while(balance>0){
            String game = scan.nextLine();
            if(game.equals("Game Time")){
                gameTime = true;
                break;
            }
            switch(game){
                case"OutFall 4":
                    balance-=39.99;
                    lastGameBought = 39.99;
                    break;
                case"CS: OG":
                    balance-=15.99;
                    lastGameBought = 15.99;
                    break;
                case"Zplinter Zell":
                    balance-=19.99;
                    lastGameBought = 19.99;
                    break;
                case"Honored 2":
                    balance-=59.99;
                    lastGameBought = 59.99;
                    break;
                case"RoverWatch":
                    balance-=29.99;
                    lastGameBought = 29.99;
                    break;
                case"RoverWatch Origins Edition":
                    balance-=39.99;
                    lastGameBought = 29.99;
                    break;
                default:
                    gameHere = true;
                    System.out.println("Not Found");
                    break;
            }
            if(balance<=0){
                System.out.println("Too Expensive");
                balance+=lastGameBought;
            }else if(balance>0 && !gameHere){
                System.out.printf("Bought %s\n", game);
            }
        }
        if(gameTime=true){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f",balanceLeft - balance, balance);
        }else{
            System.out.println("Out of money!");
        }
    }
}
