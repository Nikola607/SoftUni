package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern patternNames = Pattern.compile("(?<players>[A-Za-z])");
        Pattern patternNumbers = Pattern.compile("(?<numbers>\\d)");


        List<String> list = Arrays.stream(scan.nextLine().split(", ")).
                collect(Collectors.toList());
        Map<String, Integer> map = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("end of race")) {
            Matcher matchNames = patternNames.matcher(input);
            Matcher matchNumbers = patternNumbers.matcher(input);

            StringBuilder currentName = new StringBuilder();
            int currentDistance = 0;

            while (matchNames.find()) {
                String firstGroup = matchNames.group("players");

                currentName.append(firstGroup);
            }

            while (matchNumbers.find()) {
                int distance = Integer.parseInt(matchNumbers.group("numbers"));

                currentDistance += distance;
            }

            if (list.contains(currentName.toString())) {
                map.putIfAbsent(currentName.toString(), 0);
                map.put(currentName.toString(), map.get(currentName.toString()) + currentDistance);
            }
            input = scan.nextLine();
        }

        List<String> winners = map.entrySet().stream().
                sorted((a, b)->b.getValue().compareTo(a.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.printf("1st place: %s\n", winners.get(0));
        System.out.printf("2nd place: %s\n", winners.get(1));
        System.out.printf("3rd place: %s", winners.get(2));
    }
}
