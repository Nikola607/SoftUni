package TextProccesing;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        while(!word.equals("end")){
            String reverse = "";
            for(int i  = word.length() - 1; i>=0; i--){
                reverse += word.charAt(i);
            }
            System.out.printf("%s = %s\n", word, reverse);
            word = scan.nextLine();
        }
    }
}
