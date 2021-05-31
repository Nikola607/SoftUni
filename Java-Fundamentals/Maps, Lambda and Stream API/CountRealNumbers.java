package AssociativeArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> map = new TreeMap<>();
        double[] numbers = Arrays.stream(scan.nextLine().split(" ")).
                mapToDouble(Double::parseDouble).toArray();

        for (double i : numbers) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        for (Map.Entry<Double, Integer> i : map.entrySet()) {
            DecimalFormat dm = new DecimalFormat("#.########");
            System.out.printf("%s -> %d\n", dm.format(i.getKey()), i.getValue());
        }
    }
}
