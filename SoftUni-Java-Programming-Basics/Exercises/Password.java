import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String password = scan.nextLine();
        String current = scan.nextLine();
        while(!current.equals(password)){
            current = scan.nextLine();
        }
        System.out.printf("Welcome %s!", name);
    }
}
