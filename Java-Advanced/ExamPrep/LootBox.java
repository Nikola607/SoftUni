package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int value = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            int firstItem = firstBox.peekFirst();
            int secondItem = secondBox.peekLast();

            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                firstBox.pollFirst();
                secondBox.pollLast();

                value += sum;
            } else {
                firstBox.addLast(secondBox.pollLast());
            }
        }

        String messageBox = firstBox.isEmpty() ?
                "First lootbox is empty" :
                "Second lootbox is empty";

        String messageValue = value >= 100 ?
                String.format("Your loot was epic! Value: %s", value) :
                String.format("Your loot was poor... Value: %s", value);

        System.out.println(messageBox);
        System.out.println(messageValue);
    }
}
