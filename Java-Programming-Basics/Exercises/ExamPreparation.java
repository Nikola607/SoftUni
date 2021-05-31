import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gradesToFail = Integer.parseInt(scan.nextLine());
        double average = 0;
        int workDone = 0;
        int failedTimes = 0;
        String lastProblem = "";
        boolean isFailed = true;

        while (gradesToFail > failedTimes) {
            String workName = scan.nextLine();
            if (workName.equals("Enough")) {
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scan.nextLine());
            if (grade <= 4) {
                failedTimes++;
            }
            average +=grade;
            workDone++;
            lastProblem = workName;
        }
        average = average / workDone;
        if(isFailed){
            System.out.printf("You need a break, %d poor grades.", failedTimes);
        }else{
            System.out.printf("Average score: %.2f\n", average);
            System.out.printf("Number of problems: %d\n", workDone);
            System.out.printf("Last problem: %s\n", lastProblem);
        }
    }
}
