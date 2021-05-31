package Excercises;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int battlesWon = 0;
        boolean isWon = true;

        while(!command.equals("End of battle")){
            int energyNeeded = Integer.parseInt(command);
            if(energy - energyNeeded>=0){
                energy-=energyNeeded;
                battlesWon++;
            }else{
                isWon = false;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, energy);
                break;
            }
            if(battlesWon%3==0){
                energy+=battlesWon;
            }
            command = scan.nextLine();
        }

        if(isWon){
            System.out.printf("Won battles: %d. Energy left: %d", battlesWon, energy);
        }
    }
}
