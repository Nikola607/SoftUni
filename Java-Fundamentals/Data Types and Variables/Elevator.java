import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());
        int courses = 0;

        while (numberOfPeople > 0) {
            numberOfPeople-=capacity;
            courses++;
        }
        System.out.println(courses);
    }
}
