package Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Identity> list = new ArrayList<>();

        while (!command.equals("End")) {
            String[] data = command.split(" ");
            Identity person = new Identity(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));

            list.add(person);
            command = scan.nextLine();
        }

        list.stream()
                .sorted(Comparator.comparingInt(Identity::getAge))
                .forEach(person-> System.out.println(person.toString()));
    }

    static class Identity {
        String name;
        int id;
        int age;

        public Identity(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return String.format("%s with ID: %d is %d years old.", getName(), getId(), getAge());
        }
    }
}
