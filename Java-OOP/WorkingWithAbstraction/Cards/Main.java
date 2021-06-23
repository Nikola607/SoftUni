package WorkingWithAbstraction.Cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if(input.equals("Card Suits")) {
            System.out.println("Card Suits:");
            for (CardsSuits cards : CardsSuits.values()) {
                System.out.println(cards);
            }
        }else if(input.equals("Card Ranks")){
            System.out.println("Card Ranks:");
            for(CardRanks cards : CardRanks.values()){
                System.out.println(cards);
            }
        }
    }
}
