import java.util.Scanner;

public class Scholarship2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double income = Double.parseDouble(scan.nextLine());
        double averageSuccess = Double.parseDouble(scan.nextLine());
        double minimumWage = Double.parseDouble(scan.nextLine());
        double wageScholarship = minimumWage * 0.35;
        double successScholarship = averageSuccess * 25;

        //SocialScholarship - income < minimum wage & averageSuccess >=4.50
        //ExcellentScholarship - averageSuccess >=5.50
        //SocialScholarship - if wageScholarship > successScholarship = wage else success
        if (averageSuccess >= 5.50){
            if (averageSuccess > wageScholarship){
                System.out.printf("You get a excellent scholarship %.0f", Math.floor(successScholarship));
            }else{
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(wageScholarship));
            }
        }
        if (income < minimumWage && averageSuccess >=4.50){
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(wageScholarship));
        }else if (income > minimumWage && averageSuccess >=4.50){
            System.out.printf("You cannot get a scholarship!");
        }else if (wageScholarship > successScholarship){
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(wageScholarship));
        }else if (wageScholarship < successScholarship){
            System.out.printf("You get a excellent scholarship %.0f", Math.floor(successScholarship));
        }else {
            System.out.printf("You cannot get a scholarship!");
        }
        }
}
