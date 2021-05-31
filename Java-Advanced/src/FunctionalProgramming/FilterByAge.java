package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Function<String, Person> function = str -> {
            String[] array = str.split(", ");
            return new Person(array[0], Integer.parseInt(array[1]));
        };
        List<Person> list = new ArrayList<>();

        while (n-- > 0) {
            list.add(function.apply(scan.nextLine()));
        }

        String neededAgeType = scan.nextLine();
        int neededAge = Integer.parseInt(scan.nextLine());

        String printType = scan.nextLine();

        list = neededAgeType.equals("older") ?
                filterPeople(list, p ->p.age >= neededAge) :
                filterPeople(list, p -> p.age <= neededAge);

        System.out.println(formatPeople(list, formattedFunction(printType), System.lineSeparator()));
    }

    private static Function<Person, String> formattedFunction(String printType) {
        switch (printType) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case"name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type: " + printType);
        }
    }

    public static String formatPeople(Collection<Person> people, Function<Person, String> formatter,
                                      String delimiter){

        return people.stream().
                map(formatter::apply).
                collect(Collectors.joining(delimiter));
    }

    public static List<Person> filterPeople(Collection<Person> people,
                                            Predicate<Person> predicate){
        return people.stream().
                filter(predicate).
                collect(Collectors.toList());
    }
}
