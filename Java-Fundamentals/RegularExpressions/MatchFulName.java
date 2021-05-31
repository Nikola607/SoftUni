package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFulName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "\\b([A-Z][a-z]+ [A-Z][a-z]+)";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }

    }
}
