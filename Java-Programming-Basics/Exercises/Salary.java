import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int openedTabs = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= openedTabs; i++) {
            String siteName = scan.nextLine();
            switch (siteName) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }
            if(salary<=0){
                System.out.println("You have lost your salary.");
                break;
            }
        }
        if(salary>0) {
            System.out.println(salary);
        }
    }
}
