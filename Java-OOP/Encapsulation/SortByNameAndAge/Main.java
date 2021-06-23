package Encapsulation.SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            people.add(new Person(data[0], data[1], Integer.parseInt(data[2])));
        }

        Collections.sort(people, (firstP, secondP) -> {
            int compareP = firstP.getFirstName().compareTo(secondP.getFirstName());

            if (compareP != 0) {
                return compareP;
            } else {
                return Integer.compare(firstP.getAge(), secondP.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }
    }
}

