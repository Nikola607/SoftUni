package AssociativeArrays;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> grades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            grades.putIfAbsent(name, new ArrayList<>());
            grades.get(name).add(grade);

        }

        grades.entrySet().stream().
                sorted((a, b) -> {
                    double first = a.getValue().stream().
                            mapToDouble(Double::doubleValue).
                            average().
                            getAsDouble();
                    double second = b.getValue().stream().
                            mapToDouble(Double::doubleValue).
                            average().
                            getAsDouble();

                    return Double.compare(second, first);

                }).forEach(s -> {
                    double average = s.getValue().stream().
                            mapToDouble(Double::doubleValue).
                            average().
                            getAsDouble();
                    if(average>=4.50){
                        System.out.printf("%s -> %.2f\n", s.getKey(), average);
                    }
        });
    }
}
