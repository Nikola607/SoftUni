package SetAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        int[] firstPlayerDeck = readArray(scan);
        int[] secondPlayerDeck = readArray(scan);

        for(int i = 0; i<firstPlayerDeck.length; i++){
            firstPlayer.add(firstPlayerDeck[i]);
            secondPlayer.add(secondPlayerDeck[i]);
        }

        for(int i = 0; i<50; i++) {
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);
            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (firstCard < secondCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
        }

        if(firstPlayer.size()>secondPlayer.size()){
            System.out.println("First player win!");
        }else if(firstPlayer.size()<secondPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
    }
}
