package SetAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Integer> ores = new LinkedHashMap<>();

        while (!input.equals("stop")){
            int quantity = Integer.parseInt(scan.nextLine());

            ores.putIfAbsent(input, 0);
            ores.put(input, ores.get(input) + quantity);

            input = scan.nextLine();
        }

        ores.entrySet().stream().
                forEach(e-> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
