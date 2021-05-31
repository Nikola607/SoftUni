package SetAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for(int i = 0; i<num; i++){
            String[] input = scan.nextLine().split("\\s+");

            String continents = input[0];
            String countries = input[1];
            String cities = input[2];

            map.putIfAbsent(continents, new LinkedHashMap<>());
            map.get(continents).putIfAbsent(countries, new ArrayList<>());
            map.get(continents).get(countries).add(cities);

        }

        map.forEach((key, value) -> {
            System.out.println(key + ":");
            value.
                    forEach((k, v) -> System.out.printf("  %s -> %s\n", k, String.join(", ", v)));
        });
    }
}
