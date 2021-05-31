package ExceptionsAndErrorHandling;

import com.sun.jdi.InvalidLineNumberException;

import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                startProgram(scan);
            } catch (NumberFormatException | InvalidLineNumberException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private static void startProgram(Scanner scan) {
        int firstNum;
        int secondNum;

        try {
            firstNum = Integer.parseInt(scan.nextLine());
            secondNum = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Enter valid numbers format");
        }
        printNumbers(firstNum, secondNum);
    }

    private static void printNumbers(int firstNum, int secondNum) {
        if(firstNum>0 && firstNum < secondNum && secondNum <= 100){
            for(int i = firstNum; i<=secondNum; i++){
                System.out.print(i + " ");
            }
        }else{
            throw new InvalidLineNumberException("Number is not in given range or first number is bigger than the second one.");
        }
    }
}
