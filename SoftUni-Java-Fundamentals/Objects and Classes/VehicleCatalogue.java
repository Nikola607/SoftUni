package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Vehicles> modelCar = new ArrayList<>();

        int carCount = 0;
        int truckCount = 0;
        double carHorsePower = 0;
        double truckHorsePower = 0;

        while (!command.equals("End")) {
            String[] data = command.split(" ");
            Vehicles vehicles = new Vehicles(data[0], data[1], data[2], Integer.parseInt(data[3]));

            if (data[0].equals("car")) {
                carCount++;
                carHorsePower += Integer.parseInt(data[3]);
            }
            if (data[0].equals("truck")) {
                truckCount++;
                truckHorsePower += Integer.parseInt(data[3]);
            }

            modelCar.add(vehicles);
            command = scan.nextLine();
        }
        String cars = scan.nextLine();

        while (!cars.equals("Close the Catalogue")) {
            String model = cars;
            modelCar.stream()
                    .filter(vehicles -> vehicles.getModel().equals(model))
                    .forEach(vehicles -> System.out.println(vehicles.toString()));
            cars = scan.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", carHorsePower / carCount);
        System.out.printf("Trucks have average horsepower of: %.2f.", truckHorsePower / truckCount);

    }
}

class Vehicles {
    String typeOfVehicle;
    String model;
    String color;
    int horsePower;

    public Vehicles(String typeOfVehicle, String model, String color, int horsePower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String toString() {
        return String.format("Type: %s\n" + "Model: %s\n" + "Color: %s\n" + "Horsepower: %d",
                getTypeOfVehicle().substring(0, 1).toUpperCase() + getTypeOfVehicle().substring(1),
                getModel(),
                getColor(),
                getHorsePower());
    }
}

