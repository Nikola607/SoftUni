package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String[] command = scan.nextLine().split(" - ");

        while (!command[0].equals("Craft!")) {
            switch (command[0]) {
                case "Collect":
                    if(list.contains(command[1])){
                        break;
                    }else{
                        list.add(command[1]);
                    }
                    break;
                case "Drop":
                   if(list.contains(command[1])){
                       list.remove(command[1]);
                   }else{
                       break;
                   }
                    break;
                case "Combine Items":
                    String combineItems = command[1];
                    String[] itemsArray = combineItems.split(":");
                    if(list.contains(itemsArray[0])){
                        list.add(((list.indexOf(itemsArray[0])) + 1), itemsArray[1]);
                    }
                    break;
                case "Renew":
                    if(list.contains(command[1])){
                        list.remove(command[1]);
                        list.add(command[1]);
                    }
                    break;
            }
            command = scan.nextLine().split(" - ");
        }
        System.out.println(String.join(", ", list));
    }
}
