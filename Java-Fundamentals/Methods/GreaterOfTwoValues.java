import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();

        switch(dataType){
            case"int":
                int num1 = Integer.parseInt(scan.nextLine());
                int num2 = Integer.parseInt(scan.nextLine());
                int resultInt = printInt(num1, num2);
                System.out.println(resultInt);
                break;
            case"char":
                char symbol1 = scan.nextLine().charAt(0);
                char symbol2 = scan.nextLine().charAt(0);
                char resultChar = printChar(symbol1, symbol2);
                System.out.println(resultChar);
                break;
            case"string":
                String string1 = scan.nextLine();
                String string2 = scan.nextLine();
                String resultString = printString(string1, string2);
                System.out.println(resultString);
                break;
        }
    }

    private static String printString(String string1, String string2) {
        int firstOne = string1.compareTo(string2);
        if(firstOne>=0){
            return string1;
        }
        return string2;
    }

    private static char printChar(char symbol1, char symbol2) {
        if(symbol1>symbol2){
            return symbol1;
        }
        return  symbol2;
    }

    private static int printInt(int num1, int num2) {
        if(num1>num2){
            return num1;
        }
        return num2;
    }
}
