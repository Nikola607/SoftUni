package Exercises;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employeeOne = Integer.parseInt(scan.nextLine());
        int employeeTwo = Integer.parseInt(scan.nextLine());
        int employeeThree = Integer.parseInt(scan.nextLine());

        int peopleCount = Integer.parseInt(scan.nextLine());
        int hours = 0;
        int wholeWorkDone = employeeOne + employeeTwo + employeeThree;

        while(peopleCount>0){
            hours++;
            if(hours%4==0){
                hours++;
            }
            peopleCount-=wholeWorkDone;
        }
        System.out.println("Time needed: " + hours + "h.");
    }
}
