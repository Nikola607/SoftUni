package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] command = scan.nextLine().split(" ");
            String name = command[1];

            switch (command[0]) {
                case "register":
                    String plate = command[2];

                    if (map.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", plate);
                        break;
                    }
                    map.put(name, plate);
                    System.out.printf("%s registered %s successfully\n", name, plate);
                    break;
                case "unregister":
                    if (!map.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found\n", name);
                        break;
                    }
                    map.remove(name);
                    System.out.printf("%s unregistered successfully\n", name);
                    break;
            }
        }

        map.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
