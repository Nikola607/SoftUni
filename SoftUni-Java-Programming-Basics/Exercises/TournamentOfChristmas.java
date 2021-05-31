import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  days= Integer.parseInt(scan.nextLine());
        double sum = 0;
        String command = scan.nextLine();
        int timesWon = 0;
        int timesLost = 0;
        int sumWon = 0;

        for(int i = 1; i<=days; i++){
            while(!command.equals("Finish")){
                String sport = scan.nextLine();
                if(timesWon>timesLost){
                    sum = sumWon + sumWon * 0.1;
                }
                if(sport.equals("win")){
                    sum+=20;
                    timesWon++;
                }else if(sport.equals("lose")){
                    timesLost++;
                }
                sum+=sum;
                sumWon+=sum;
                command = scan.nextLine();
            }
        }
        if (timesWon > timesLost) {
            sum = sum + sum * 0.2;
            System.out.println("You wont the tournament!");
            System.out.printf(" Total raised money: %.2f", sum);
        } else {
            System.out.println("You lost the tournament!");
            System.out.printf(" Total raised money: %.2f", sum);
        }
    }
}
