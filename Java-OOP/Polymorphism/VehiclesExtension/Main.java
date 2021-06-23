package Polymorphism.VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInput = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));

        String[] truckInput = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));

        String[] busInput = scan.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));

        Map<String, Vehicle> map = new LinkedHashMap<>();

        map.put("Car", car);
        map.put("Truck", truck);
        map.put("Bus", bus);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");

            switch (command[0]) {
                case "Drive":
                    map.get(command[1]).drive(Double.parseDouble(command[2]));
                    break;
                case "Refuel":
                    try {
                        map.get(command[1]).refuel(Double.parseDouble(command[2]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    bus.setEmpty(false);
                    bus.drive(Double.parseDouble(command[2]));
                    break;
            }
        }

        System.out.print(car);
        System.out.print(truck);
        System.out.print(bus);
    }
}
