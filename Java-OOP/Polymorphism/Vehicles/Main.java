package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInput = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));

        String[] truckInput = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int n = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");
            switch (command[0]) {
                case "Drive":
                    if(command[1].equals("Car")){
                        car.drive(Double.parseDouble(command[2]));
                    }else{
                        truck.drive(Double.parseDouble(command[2]));
                    }
                    break;
                case "Refuel":
                    if(command[1].equals("Car")){
                        car.refuel(Double.parseDouble(command[2]));
                    }else{
                        truck.refuel(Double.parseDouble(command[2]));
                    }
                    break;
            }
        }
        System.out.print(car);
        System.out.print(truck);
    }
}
