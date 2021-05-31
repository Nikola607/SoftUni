package SetAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();
        String[] input = scan.nextLine().split(", ");

        while (!input[0].equals("END")){
           boolean currentCar = input[0].equals("IN") ?
                    set.add(input[1]) :
                    set.remove(input[1]);
           input = scan.nextLine().split(", ");
        }
        if(!set.isEmpty()) {
            set.forEach(System.out::println);
        }else{
            System.out.println("Parking Lot is Empty");
        }
    }
}
