package TextProccesing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String i : words) {
            if (text.contains(i)) {
                String replacement = replaceString("*", i.length());
                text = text.replace(i, replacement);
            }
        }
        System.out.println(text);
    }

    private static String replaceString(String s, int length) {
        String replacement = "";
        for (int i = 0; i < length; i++) {
            replacement+=s;
        }
        return replacement;
    }
}
