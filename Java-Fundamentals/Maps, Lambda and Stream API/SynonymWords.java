package AssociativeArrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class SynonymWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();

        for(int i = 0; i<n; i++){
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(synonym);
        }

        for(Map.Entry<String, ArrayList<String>> i : map.entrySet()){
            System.out.printf("%s - %s \n", i.getKey(), String.join(", ", i.getValue()));
        }
    }
}
