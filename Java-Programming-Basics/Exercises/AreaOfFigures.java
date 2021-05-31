import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // square = a * a
        // rectangle = a * b
        // circle = Math.pi * r^2
        // triangle = ( a * b ) / 2
        String shape = scan.nextLine();
        if (shape.equals("square")){
            double sideA = Double.parseDouble(scan.nextLine());
            double squareArea = sideA * sideA;
            System.out.printf("%.03f", squareArea);
        }else if(shape.equals("rectangle")){
            double sideAa = Double.parseDouble(scan.nextLine());
            double sideBb = Double.parseDouble(scan.nextLine());
            double rectangleArea = sideAa * sideBb;
            System.out.printf("%.03f", rectangleArea);
        }else if (shape.equals("circle")){
            double sideR = Double.parseDouble(scan.nextLine());
            double circleArea = Math.PI * sideR * sideR;
            System.out.printf("%.03f", circleArea);
        }else if (shape.equals("triangle")){
            double sideAaa = Double.parseDouble(scan.nextLine());
            double sideBbb = Double.parseDouble(scan.nextLine());
            double triangleArea = (sideAaa * sideBbb) / 2;
            System.out.printf("%.03f", triangleArea);
        }
    }
}
