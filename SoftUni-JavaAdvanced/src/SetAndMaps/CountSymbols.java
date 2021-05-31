package SetAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("");
        Map<String, Integer> symbols = new TreeMap<>();

        for(int i = 0; i<input.length; i++){
            symbols.putIfAbsent(input[i], 0);
            symbols.put(input[i], symbols.get(input[i]) + 1);
        }

        symbols.entrySet().stream().
                forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " time/s"));
    }
}
