import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String  command = scan.nextLine();
        int bottles = Integer.parseInt(scan.nextLine());
        int mlBottles = bottles * 750;
        int timesLooped = 0;
        int detergentNeeded = 0;
        int cleanPots = 0;
        int cleanPlates = 0;
        boolean end = false;

        while(mlBottles>0){
            timesLooped++;
            int dishes = Integer.parseInt(command);
            if(timesLooped %3==0){
                mlBottles = dishes * 15 - mlBottles;
                cleanPots +=dishes;
            }
            else{
                mlBottles = dishes * 5 - mlBottles;
                cleanPlates+=dishes;
            }
            if(mlBottles<=0){
                detergentNeeded = Math.abs(mlBottles);
                end = true;
                break;
            }
            if(command.equals("End")){
                break;
            }
        }

        if(end){
            System.out.printf("Not enough detergent, %d ml. more necessary!",detergentNeeded );
        }
        else{
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.", cleanPlates, cleanPots);
            System.out.printf("Leftover detergent %d ml.");
        }
    }
}
