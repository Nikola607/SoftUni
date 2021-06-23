package SetAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] input = Arrays.stream(scan.nextLine().split(" ")).
                mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (Double i : input) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        map.entrySet().forEach((e -> System.out.printf("%.1f -> %d\n", e.getKey(), e.getValue())));
    }
}
