import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        printCountVowels(word);
    }

    private static void printCountVowels(String word) {
        int counter = 0;
        word = word.toLowerCase();
        for(int i = 0; i<word.length(); i++){
            char vowels = word.charAt(i);
            switch(vowels){
                case'a':
                    counter++;
                    break;
                case'e':
                    counter++;
                    break;
                case'o':
                    counter++;
                    break;
                case'u':
                    counter++;
                    break;
                case'i':
                    counter++;
                    break;
                case'y':
                    counter++;
                    break;
            }
        }
        System.out.println(counter);
    }
}
