import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);
        printSymbolsInRange(symbol1, symbol2);
    }

    private static void printSymbolsInRange(char symbol1, char symbol2) {
        for(int i = symbol1 + 1; i<symbol2; i++){
            char symbol = (char)i;
            System.out.print(symbol + " ");
        }
    }
}
