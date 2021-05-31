package SetAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("-");
        Map<String, String> contacts = new LinkedHashMap<>();

        while (!input[0].equals("search")) {
            String name = input[0];
            String number = input[1];

            contacts.putIfAbsent(name, number);

            input = scan.nextLine().split("-");
        }

        String searchNames = scan.nextLine();
        while (!searchNames.equals("stop")) {
            if(contacts.containsKey(searchNames)){
                System.out.printf("%s -> %s\n", searchNames, contacts.get(searchNames));
            }else{
                System.out.println("Contact " + searchNames + " does not exist.");
            }
            searchNames = scan.nextLine();
        }
    }
}
