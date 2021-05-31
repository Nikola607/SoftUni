package Exercises;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");

        Random random = new Random();
        for (int i = 0; i < words.length; i++) {
            int x = random.nextInt(words.length);
            int y = random.nextInt(words.length);

            String oldWords = words[x];
            words[x] = words[y];
            words[y] = oldWords;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
