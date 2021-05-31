package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\b(?<day>[0-3]\\d)([-.\\/])(?<Month>[A-Z][a-z]{2})\\2(?<Year>\\d{4})\\b";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);

        while(match.find()){
            String day = match.group("day");
            String month = match.group("Month");
            String year = match.group("Year");

            System.out.printf("Day: %s, Month: %s, Year: %s\n", day, month, year);
        }
    }
}
