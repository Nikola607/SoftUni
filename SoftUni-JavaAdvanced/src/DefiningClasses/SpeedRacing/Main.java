package DefiningClasses.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> map = new LinkedHashMap<>();

        while (n-- > 0){
            String[] data = scan.nextLine().split("\\s+");

            String model = data[0];
            int fuelAmount = Integer.parseInt(data[1]);
            double fuelPrice = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelPrice);
            map.putIfAbsent(model, car);
        }

        String[] command = scan.nextLine().split("\\s+");

        while (!command[0].equals("End")){
            String model = command[1];
            int kmToDrive = Integer.parseInt(command[2]);

            map.get(model).Drive(kmToDrive);

            command = scan.nextLine().split("\\s+");
        }

        map.entrySet().stream().
                forEach(e -> System.out.printf("%s %.2f %s\n", e.getKey(), e.getValue().getFuelAmount(), e.getValue().distance));
    }
}
