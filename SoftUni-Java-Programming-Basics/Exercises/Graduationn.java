import java.util.Scanner;

public class Graduationn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        double grade = 1;
        double repetition = 0;
        double sum = 0;
        boolean excluded = false;

        while (grade <= 12) {
            double currentGrade = Double.parseDouble(scan.nextLine());
            if (currentGrade < 4) {
                repetition++;
                if (repetition == 2) {
                    System.out.printf("%s has been excluded at %.0f grade", name, grade);
                    excluded = true;
                    break;
                }
                continue;
            }
            sum += currentGrade;
            grade++;
        }
        if (!excluded) {
            double average = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, average);
        }
    }
}
