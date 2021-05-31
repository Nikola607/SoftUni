package AssociativeArrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();

        for(String i : words){
            String lowerCase = i.toLowerCase();
            if(map.containsKey(lowerCase)){
                map.put(lowerCase, map.get(lowerCase) + 1);
            }else{
                map.put(lowerCase, 1);
            }
        }

        ArrayList<String> odds = new ArrayList<>();

        for(var i : map.entrySet()){
            if(i.getValue()%2==1){
                odds.add(i.getKey());
            }
        }

        System.out.print(String.join(", ", odds));
    }
}
