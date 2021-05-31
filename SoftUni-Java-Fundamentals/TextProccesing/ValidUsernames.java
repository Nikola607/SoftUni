package TextProccesing;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(", ");

        for(String i : names){
            if(isValidUserName(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isValidUserName(String i) {
        if(i.length()<3 || i.length()>16){
            return false;
        }

        for(int j = 0; j<i.length(); j++){
            char currentSymbol = i.charAt(j);

            if(!Character.isLetterOrDigit(currentSymbol)&& currentSymbol!='-' && currentSymbol!='_'){
                return false;
            }
        }
        return true;
    }


}
