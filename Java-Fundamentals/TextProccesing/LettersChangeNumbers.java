package TextProccesing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        double sum = 0;

        for (String i : input) {

            char first = i.charAt(0);
            char second = i.charAt(i.length() - 1);
            double numbers = Double.parseDouble(i.substring(1, i.length() - 1));

            double valueFirst = firstAlphabetPosition(first, numbers);
            double valueSecond = secondAlphabetPosition(second, valueFirst);

            sum +=valueSecond;

        }

        System.out.printf("%.2f", sum);
    }

    private static double secondAlphabetPosition(char second, double valueFirst) {

        if (second >= 'a' && second <= 'z') {
            int positionOfLetter = Character.toUpperCase(second) - 64;

            valueFirst += positionOfLetter;
        } else {
            int position = Character.toUpperCase(second) - 64;

            valueFirst -= position;
        }
        return valueFirst;

    }

    private static double firstAlphabetPosition(char first, double numbers) {
        double sum;

        if (Character.isUpperCase(first)) {
            int positionOfLetter = Character.toUpperCase(first) - 64;

            sum = numbers / positionOfLetter;
        } else {
            int position = Character.toUpperCase(first) - 64;

            sum = numbers * position;
        }
        return sum;
    }
}
