import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        boolean passwordLength = printPasswordLength(password);
        boolean passwordConsist = printPasswordConsist(password);
        boolean passwordDigits = printPasswordDigits(password);
        if (!passwordLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!passwordConsist) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!passwordDigits) {
            System.out.println("Password must have at least 2 digits");
        } if(passwordConsist && passwordDigits && passwordLength) {
            System.out.println("Password is valid");
        }
    }

    private static boolean printPasswordDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            if (isDigit) {
                counter++;
            }
        }
        return counter >= 2;
    }

    private static boolean printPasswordConsist(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            boolean isLetter = Character.isLetter(symbol);

            if (!isDigit && !isLetter) {
                return false;
            }
        }
        return true;
    }

    private static boolean printPasswordLength(String password) {
        return (password.length() >= 6 && password.length() <= 10);
    }
}
