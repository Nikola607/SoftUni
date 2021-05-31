import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bestPlayer = "";
        int max = Integer.MIN_VALUE;
        String playerName;
        while (!(playerName = scan.nextLine()).equals("END")){
            int currentGoals = Integer.parseInt(scan.nextLine());
            if (currentGoals > max){

                bestPlayer = playerName;
                max = currentGoals;
            }
            if (max >= 10){
                break;
            }
        }
        System.out.printf("%s is the best player!\n", bestPlayer);
        if (max >= 3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", max);
        }
        else {
            System.out.printf("He has scored %d goals.", max);
        }
    }
}