import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggsInShop = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int eggsSold = 0;

        while(!command.equals("Close")){
            if(command.equals("Buy")){
                int eggsToBuy = Integer.parseInt(scan.nextLine());
                if(eggsInShop < eggsToBuy){
                    System.out.println("Not enough eggs in store!");
                    System.out.printf("You can buy only %d.", eggsInShop);
                }
                eggsInShop -=eggsToBuy;
                eggsSold += eggsToBuy;
            }else if(command.equals("Fill")){
                int eggsToFill = Integer.parseInt(scan.nextLine());
                eggsInShop +=eggsToFill;
            }
            command = scan.nextLine();
        }
        System.out.println("Store is closed!");
        System.out.printf("%d eggs sold.", eggsSold);
    }
}
