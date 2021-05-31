import java.util.Scanner;

public class WeatherForecastVol2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double temperature = Double.parseDouble(scan.nextLine());

        if(temperature>=26 && temperature<=35){
            System.out.printf("Hot");
        }
        else if(temperature>=20.1 && temperature<=25.9){
            System.out.printf("Warm");
        }
        else if(temperature>=15 && temperature<=20){
            System.out.printf("Mild");
        }
        else if(temperature>=12 && temperature<=14.9){
            System.out.printf("Cool");
        }
        else if(temperature>=5&& temperature<=11.9){
            System.out.printf("Cold");
        }
        else{
            System.out.printf("unknown");
        }
    }
}
