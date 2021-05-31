package TextProccesing;

import java.util.Scanner;

public class DigitLettersAndOthers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        StringBuilder isDigit = new StringBuilder();
        StringBuilder isLetter = new StringBuilder();
        StringBuilder isSymbol = new StringBuilder();

        for(int i = 0; i<word.length(); i++){
            char currentIndex = word.charAt(i);
            if(Character.isDigit(currentIndex)){
                isDigit.append(currentIndex);
            }else if(Character.isLetter(currentIndex)){
                isLetter.append(currentIndex);
            }else{
                isSymbol.append(currentIndex);
            }
        }
        System.out.printf("%s\n%s\n%s", isDigit, isLetter, isSymbol);

    }
}
