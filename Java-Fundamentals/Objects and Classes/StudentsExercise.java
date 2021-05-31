package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsExercise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Students> list =new ArrayList<>();

        for(int i = 0; i<n; i++){
            String[] students = scan.nextLine().split(" ");
            Students people = new Students(students[0], students[1], Double.parseDouble(students[2]));

            list.add(people);
        }
        list.stream()
                .sorted((p1, p2)->Double.compare(p2.getGrade(), p1.getGrade()))
                .forEach(people -> System.out.println(people.toString()));
    }
    static class Students{
        String firstName;
        String lastName;
        double grade;

        public Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }
        public String toString(){
            return String.format("%s %s: %.2f",getFirstName(), getLastName(), getGrade());
        }
    }
}
