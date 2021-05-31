package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        Map<String, Integer> map = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            int value = Integer.parseInt(scan.nextLine());

            if(map.containsKey(command)){
                map.put(command, map.get(command) + value);
            }

            map.putIfAbsent(command, value);

            command = scan.nextLine();
        }

        map.forEach((key, value) -> System.out.printf("%s -> %s", key, value));
    }
}
