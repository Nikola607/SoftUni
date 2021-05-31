package WorkingWithAbstraction.TraficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<n; i++){
            for(int j = 0; j<input.length; j++){
                Lights lights = Lights.valueOf(input[j]);

                input[j] = lights.changer(input[j]);
                System.out.print(input[j] + " ");
            }
            System.out.println();
        }
    }
}
