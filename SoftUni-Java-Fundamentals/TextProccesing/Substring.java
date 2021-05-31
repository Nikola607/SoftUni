package TextProccesing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String sentence = scan.nextLine();

        int nextIndex = sentence.indexOf(word);

        while (nextIndex != -1){
            sentence = sentence.replace(word, "");
            nextIndex = sentence.indexOf(word);
        }
        System.out.println(sentence);
    }
}
