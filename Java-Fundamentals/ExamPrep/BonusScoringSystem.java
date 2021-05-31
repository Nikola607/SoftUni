package Excercises;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scan.nextLine());
        int lecturesCount = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int bestLectures = 0;

        for (int i = 0; i < studentsCount; i++) {
            int studentAttendances = Integer.parseInt(scan.nextLine());
            double totalBonus = (double) studentAttendances / lecturesCount * (5 + bonus);
            if(totalBonus>maxBonus){
                maxBonus = totalBonus;
                bestLectures=studentAttendances;
            }
        }
        System.out.println("Max Bonus: " + Math.round(maxBonus) + ".");
        System.out.printf("The student has attended %d lectures.", bestLectures);
    }
}
