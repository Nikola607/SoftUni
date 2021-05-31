package ExceptionsAndErrorHandling.ValidPerson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            createPerson(scan);
        }catch (IllegalArgumentException e){
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }

    private static void createPerson(Scanner scan) {
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        Person person = new Person(firstName, lastName, age);
    }
}
