import java.util.Scanner;

public class Steps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int totalSteps = 0;
        while (!command.equals("Going home")) {
            int steps = Integer.parseInt(command);
            totalSteps += steps;
            if (totalSteps >= 10000){
                break;
            }
            command = scan.nextLine();
        }
        if(command.equals("Going home")){
            int stepsHome = Integer.parseInt(scan.nextLine());
            totalSteps+=stepsHome;
        }
        if(totalSteps>=10000){
            System.out.println("Goal reached! Good job!");
            int moreSteps = totalSteps - 10000;
            System.out.printf("%d steps over the goal!", moreSteps);
        }else{
            int diffSteps = 10000 - totalSteps;
            System.out.printf("%d more steps to reach goal.", diffSteps);
        }
    }
}
