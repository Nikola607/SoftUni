package TextProccesing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] list = scan.nextLine().split(" ");

        for(String currentWord : list){
            for(int f = 0; f<currentWord.length(); f++){
                System.out.print(currentWord);
            }
        }
    }
}
