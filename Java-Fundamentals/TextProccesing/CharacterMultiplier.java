package TextProccesing;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        String first = input[0];
        String second = input[1];
        int result = multiplyDigits(first, second);
        System.out.println(result);
    }

    private static int multiplyDigits(String first, String second) {
        int sum = 0;

        if(first.length()>= second.length()){

            for(int i  = 0; i<first.length(); i++){
                char firstOne = first.charAt(i);

                if(i>=second.length()){
                    sum+=firstOne;

                }else {
                    char secondOne = second.charAt(i);

                    sum += firstOne * secondOne;
                }
            }
        }else{
            for(int i  = 0; i<second.length(); i++){
                char secondOne = second.charAt(i);

                if(i>=first.length()){
                    sum+=secondOne;

                }else {
                    char firstOne = first.charAt(i);

                    sum += firstOne * secondOne;
                }
            }
        }
        return sum;
    }
}
