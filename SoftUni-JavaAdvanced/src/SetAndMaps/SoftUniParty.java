package SetAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (!input.equals("PARTY")){
            if(checkTypeOfGuest(input)){
                vipGuests.add(input);
            }else{
                regularGuests.add(input);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("END")){
            if(checkTypeOfGuest(input)){
                vipGuests.remove(input);
            }else{
                regularGuests.remove(input);
            }
            input = scan.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());

        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }

    private static boolean checkTypeOfGuest(String input) {
        return Character.isDigit(input.charAt(0));
    }
}
