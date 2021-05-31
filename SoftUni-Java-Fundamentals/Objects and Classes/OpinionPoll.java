package Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Identity> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            Identity people = new Identity(data[0], Integer.parseInt(data[1]));
            list.add(people);
        }
        list.stream()
                .filter(people -> people.getAge() > 30)
                .sorted(Comparator.comparing(Identity::getName))
                .forEach(people -> System.out.println(people.toString()));
    }

    static class Identity {
        String name;
        int age;

        public Identity(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return String.format("%s - %d", getName(), getAge());
        }
    }
}
