package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i)!=' '){
                char character = word.charAt(i);
                if(map.containsKey(character)){
                    map.put(character, map.get(character) + 1);
                }else{
                    map.put(character, 1);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
