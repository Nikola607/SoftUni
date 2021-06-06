package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();

        while (matcher.find()){
            list.add(matcher.group());
        }
        System.out.println(String.join(", ", list));
    }
}