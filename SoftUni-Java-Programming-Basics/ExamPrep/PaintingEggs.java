import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String size = scan.nextLine();
        String colour = scan.nextLine();
        int numbersOfEggs = Integer.parseInt(scan.nextLine());
        double sum = 0;
        switch(size){
            case"Large":
                switch(colour){
                    case"Red":
                        sum = 16 * numbersOfEggs;
                        break;
                    case"Green":
                        sum = 12 * numbersOfEggs;
                        break;
                    case"Yellow":
                        sum = 9 * numbersOfEggs;
                        break;
                }
                break;
            case"Medium":
                switch(colour){
                    case"Red":
                        sum = 13 * numbersOfEggs;
                        break;
                    case"Green":
                        sum = 9 * numbersOfEggs;
                        break;
                    case"Yellow":
                        sum = 7 * numbersOfEggs;
                        break;
                }
                break;
            case"Small":
                switch(colour){
                    case"Red":
                        sum = 9 * numbersOfEggs;
                        break;
                    case"Green":
                        sum = 8 * numbersOfEggs;
                        break;
                    case"Yellow":
                        sum = 5 * numbersOfEggs;
                        break;
                }
                break;
        }
        double finalSum = sum - sum * 0.35;
        System.out.printf("%.2f leva.", finalSum);
    }
}
