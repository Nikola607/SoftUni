import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        String output = scan.nextLine();
        if (input.equals("cm")){
        }else if (input.equals("m")){
            number = number * 100;
        }else if (input.equals("mm")){
            number = number / 100;
        }
        if (input.equals("cm")){
        }else if (input.equals("m")){
            number = number / 100;
        }else if (input.equals("mm")){
            number = number * 1000;
        }
        System.out.printf("%.3f", number);
    }
}
