package SetAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String emails = scan.nextLine();
            if (!emails.contains(".us") && !emails.contains(".uk") && !emails.contains(".com")) {

                map.putIfAbsent(input, emails);
            }
            input = scan.nextLine();
        }

        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
