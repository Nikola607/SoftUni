import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        printResult(num1, num2, command);
    }

    private static void printResult(int num1, int num2, String command) {
        if (command.equals("add")) {
            System.out.println(num1 + num2);
        } else if (command.equals("multiply")) {
            System.out.println(num1 * num2);
        }else if(command.equals("subtract")){
            System.out.println(num1 - num2);
        }else if(command.equals("divide")){
            System.out.println(num1 / num2);
        }
    }
}

