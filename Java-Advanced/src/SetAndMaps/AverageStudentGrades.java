package SetAndMaps;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());                  //Numbers of students
        String[] input = scan.nextLine().split("\\s+");

        Map<String, List<Double>> map = new TreeMap<>();

        for(int i = 0; i<num; i++){
            String studentName = input[0];
            double grade = Double.parseDouble(input[1]);

            map.putIfAbsent(studentName, new ArrayList<>());
            map.get(studentName).add(grade);

            input = scan.nextLine().split("\\s+");
        }

        map.entrySet().stream().forEach(e->{
            double sum = 0;

            for(int i = 0; i<e.getValue().size(); i++){
                sum+=e.getValue().get(i);
            }

            double average = sum / e.getValue().size();
            System.out.print(e.getKey() + " ->");
            e.getValue().forEach(entry -> System.out.printf(" %.2f", entry));
            System.out.printf(" (avg: %.2f)\n", average);
        });
    }
}
