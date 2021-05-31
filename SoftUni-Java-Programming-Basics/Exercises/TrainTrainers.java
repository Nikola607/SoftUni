import java.util.Scanner;

public class TrainTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countJury = Integer.parseInt(scan.nextLine());
        int countGrades = 0;
        double sumGradesAllPresentation = 0;

        while (true) {
            String presentation = scan.nextLine();
            if (presentation.equals("Finish")) {
                break;
            }
            double sumGradesPerPresentation = 0;
            for (int i = 1; i <= countJury; i++) {
                double grade = Double.parseDouble(scan.nextLine());
                sumGradesPerPresentation += grade;
                sumGradesAllPresentation += grade;
                countGrades++;

            }
            double average = sumGradesPerPresentation / countJury;
            System.out.printf("%s - %.2f\n", presentation, average);
        }
        double averageAll = sumGradesAllPresentation / countGrades;
        System.out.printf("Student's final assessments is %.2f.", averageAll);
    }
}
