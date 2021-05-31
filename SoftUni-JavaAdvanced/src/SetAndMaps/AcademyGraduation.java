package SetAndMaps;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        Map<String, double[]> map = new TreeMap<>();
        String pattern = "#.################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+")).
                    mapToDouble(Double::parseDouble).toArray();

            map.put(name, grades);
        }

        map.entrySet().stream().forEach(e -> {
            double sum = 0;

            for (int i = 0; i < e.getValue().length; i++) {
                sum += e.getValue()[i];
            }

            double average = sum / e.getValue().length;
            String format = decimalFormat.format(average);
            System.out.printf("%s is graduated with ", e.getKey());
            System.out.printf("%s\n", format);
        });
    }
}
