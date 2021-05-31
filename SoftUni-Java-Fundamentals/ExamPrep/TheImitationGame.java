package ExamExercise;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] commands = scan.nextLine().split("\\|");

        while (!commands[0].equals("Decode")) {
            switch (commands[0]) {
                case "Move":
                    int moveFirstLetters = Integer.parseInt(commands[1]);
                    String string = "";
                    StringBuilder sb = new StringBuilder();
                    sb.append(input);
                    string = sb.substring(0, moveFirstLetters);
                    sb.replace(0, moveFirstLetters, "");
                    sb.append(string);
                    input = sb.toString();

                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[1]);
                    String value = commands[2];
                    StringBuilder secondSb = new StringBuilder(input);
                    secondSb.insert(index, value);
                    input = secondSb.toString();

                    break;
                case "ChangeAll":
                    String stringToChange = commands[1];
                    String replacement = commands[2];
                    input = input.replace(stringToChange, replacement);

                    break;
            }
            commands = scan.nextLine().split("\\|");
        }
        System.out.println("The decrypted message is: " + input);
    }
}
