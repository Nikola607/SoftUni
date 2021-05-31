package AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> studentCount = new LinkedHashMap<>();

        String[] command = scan.nextLine().split(" : ");

        while (!command[0].equals("end")) {
            String courseName = command[0];
            String studentName = command[1];

            if (!studentCount.containsKey(courseName)) {
                studentCount.put(courseName, new ArrayList<>());
                studentCount.get(courseName).add(studentName);
            } else {
                if (!studentCount.get(courseName).contains(studentName)) {
                    studentCount.get(courseName).add(studentName);
                }
            }

            command = scan.nextLine().split(" : ");
        }
                
       studentCount.entrySet().stream()
               .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size())).
               forEach(entry -> {
                   System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
                   entry.getValue().stream().sorted(String::compareTo).
                           forEach(e -> System.out.printf("-- %s\n", e));
               });
    }
}
