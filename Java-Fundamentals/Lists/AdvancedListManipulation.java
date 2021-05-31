import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvancedListManipulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumbers(scan);

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] commandAsArray = command.split(" ");

            switch (commandAsArray[0]) {
                case "Contains":
                    int number = Integer.parseInt(commandAsArray[1]);
                    if (numbers.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String action = commandAsArray[1];

                    List<Integer> printList = new ArrayList<>();

                    if (action.equals("even")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                printList.add(numbers.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                printList.add(numbers.get(i));
                            }
                        }
                    }
                    for (int i : printList) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;

                    for (int i = 0; i < numbers.size(); i++) {
                        sum+=numbers.get(i);
                    }
                    System.out.print(sum + " ");
                    System.out.println();
                    break;
                case "Filter":
                    String symbol = commandAsArray[1];
                    int value = Integer.parseInt(commandAsArray[2]);

                    List<Integer> filterList = new ArrayList<>();

                    for(int i = 0; i<numbers.size(); i++) {
                        switch (symbol) {
                            case "<":
                                if(numbers.get(i)<value){
                                    filterList.add(numbers.get(i));
                                }
                                break;
                            case ">":
                                if(numbers.get(i)>value){
                                    filterList.add(numbers.get(i));
                                }
                                break;
                            case "<=":
                                if(numbers.get(i)<=value){
                                    filterList.add(numbers.get(i));
                                }
                                break;
                            case ">=":
                                if(numbers.get(i)>=value){
                                    filterList.add(numbers.get(i));
                                }
                                break;
                        }
                    }
                    for(int i: filterList){
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
            }
            command = scan.nextLine();
        }
    }

    public static List<Integer> parseLineOfNumbers(Scanner scan) {
        String line = scan.nextLine();

        String[] numbersAsString = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String i : numbersAsString) {
            int number = Integer.parseInt(i);
            numbers.add(number);
        }
        return numbers;
    }
}
