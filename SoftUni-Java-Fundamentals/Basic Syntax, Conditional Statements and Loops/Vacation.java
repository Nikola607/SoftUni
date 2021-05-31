package Bg.SoftUni.Fundamentals;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scan.nextLine());
        String typePeople = scan.nextLine();
        String dayOfWeek = scan.nextLine();
        double totalPrice = 0;

        switch (typePeople) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = numberOfPeople * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = numberOfPeople * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = numberOfPeople * 10.46;
                        break;
                }
                break;
            case "Business":
                if(numberOfPeople >=100){
                    numberOfPeople-=10;
                }
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = numberOfPeople * 10.90;
                        break;
                    case "Saturday":
                        totalPrice = numberOfPeople * 15.60;
                        break;
                    case "Sunday":
                        totalPrice = numberOfPeople * 16;
                        break;
                }
                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = numberOfPeople * 15;
                        break;
                    case "Saturday":
                        totalPrice = numberOfPeople * 20;
                        break;
                    case "Sunday":
                        totalPrice = numberOfPeople * 22.50;
                        break;
                }
                break;
        }
        if (typePeople.equals("Students") && numberOfPeople >= 30) {
            totalPrice -= totalPrice * 0.15;
        } else if (typePeople.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
            totalPrice -= totalPrice * 0.05;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
