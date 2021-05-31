package TextProccesing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        StringBuilder sb = new StringBuilder();

        char previousChar = text.charAt(0);
        sb.append(previousChar);

        for(int i = 1; i<text.length(); i++){
            char currentChar = text.charAt(i);

            if(previousChar!=currentChar){
                sb.append(currentChar);

                previousChar = currentChar;
            }
        }
        System.out.println(sb);
    }
}
