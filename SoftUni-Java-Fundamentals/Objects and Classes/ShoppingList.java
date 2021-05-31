package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String[] commands = scan.nextLine().split(" ");

        while (!commands[0].equals("Go")) {
            switch ((commands[0])) {
                case "Urgent":
                    if (list.contains(commands[1])) {
                        break;
                    } else {
                        list.add(0, commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if(list.contains(commands[1])){
                        list.remove(commands[1]);
                    }else{
                        break;
                    }
                    break;
                case "Correct":
                    if (list.contains(commands[1])) {
                        list.set(list.indexOf(commands[1]), commands[2]);
                    } else {
                        break;
                    }
                    break;
                case "Rearrange":
                    if (list.contains(commands[1])) {
                        list.remove(commands[1]);
                        list.add(commands[1]);
                    } else {
                        break;
                    }
                    break;
            }
            commands = scan.nextLine().split(" ");
        }
        System.out.println(String.join(", ", list));
    }
}
