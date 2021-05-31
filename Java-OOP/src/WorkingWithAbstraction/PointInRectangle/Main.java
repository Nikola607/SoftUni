package WorkingWithAbstraction.PointInRectangle;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scan.nextLine());

        Rectangle rectangle = new Rectangle(new Point(input[0], input[1]), new Point(input[2], input[3]));

        for(int i = 0; i<n; i++){
            int[] points = Arrays.stream(scan.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();

            Point pointsToCheck = new Point(points[0], points[1]);

            System.out.println(rectangle.contains(pointsToCheck));
        }
    }
}
