package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<OpinionPoll> list = new ArrayList<>();

        while (n-- > 0){
            String[] data = scan.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            OpinionPoll people = new OpinionPoll(name, age);
            list.add(people);
        }

        list.stream().filter(e -> e.getAge() > 30).
                sorted((a, b) -> a.getName().compareTo(b.getName())).
                forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
