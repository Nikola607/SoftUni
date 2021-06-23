package DefiningClasses.RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tires[] tires = new Tires[4];
            int count = 0;
            for (int i = 5; i < data.length; i += 2) {
                double tirePressure = Double.parseDouble(data[i]);
                int tireAge = Integer.parseInt(data[i + 1]);

                tires[count] = new Tires(tireAge, tirePressure);
                count++;
            }

            Car car = new Car(model, engine, cargo, tires);
            map.put(model, car);
        }

        String cargoType = scan.nextLine();

        for (Car car : map.values()) {
            if (cargoType.equals("fragile") &&
                    cargoType.equals(car.getCargo().getCargoType()) &&
                    car.tiresCheck()) {
                System.out.println(car);
            } else if (cargoType.equals("flamable") &&
                    car.getCargo().getCargoType().equals(cargoType) &&
                    car.getEngine().getEnginePower() > 250){
                System.out.println(car);
            }
        }
    }
}
