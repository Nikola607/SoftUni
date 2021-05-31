package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] commands = scan.nextLine().split("\\s+");

        Box<String> box = new Box<>();

        while (!commands[0].equals("END")){

            switch (commands[0]){
                case"Add":
                    String input = commands[1];
                    box.addElement(input);
                    break;
                case"Remove":
                    int indexToRemove = Integer.parseInt(scan.nextLine());
                    box.removeElement(indexToRemove);
                    break;
                case"Contains":
                    String contain = commands[1];
                    if(box.containsElement(contain)){
                        System.out.println("true");
                    }else{
                        System.out.println("false");
                    }
                    break;
                case"Swap":
                    int firstIndex = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);
                    box.swapElements(firstIndex, secondIndex);
                    break;
                case"Greater":
                    String greater = commands[1];
                    System.out.println(box.greaterThan(greater));
                    break;
                case"Max":
                    System.out.println(box.getMax());
                    break;
                case"Min":
                    System.out.println(box.getMin());
                    break;
                case"Print":
                    System.out.println(box);
                    break;
            }
            commands = scan.nextLine().split("\\s+");
        }
    }
}
