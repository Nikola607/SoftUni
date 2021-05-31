package TextProccesing;

import java.util.Scanner;

public class CeasarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        for(Character i : input.toCharArray()){
            System.out.print((char)(i + 3));
        }

    }
}
