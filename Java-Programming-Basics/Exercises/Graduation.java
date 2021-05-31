import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        double sum = 0;
        int grade = 1;
        int repetition = 0;

        while (grade <= 12) {
            double currentMark = Double.parseDouble(scan.nextLine());
            if (currentMark < 4) {
                repetition++;
                if (repetition == 2) {
                    System.out.printf("%s has been excluded at %d grade", name, grade);
                    break;
                }
                continue;
            }
            sum += currentMark;
            grade++;
        }
        double average = sum / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, average);
    }
}
