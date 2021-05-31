import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int timesLooped = Integer.parseInt(scan.nextLine());
        printResult(word, timesLooped);
    }

    private static void printResult(String word, int timesLooped) {
        for(int i = 0; i<timesLooped;i++){
            System.out.print(word);
        }
    }
}
