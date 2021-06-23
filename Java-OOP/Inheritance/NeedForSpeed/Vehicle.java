package Inheritance.NeedForSpeed;

//	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
// 	fuelConsumption –double
//  fuel – double
//  horsePower – int
// 	Getters and Setters for the fields


public class Vehicle {
     private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
     private double fuelConsumption;
     private double fuel;
     private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public void drive (double kilometers){
        double consumedFuel = kilometers * this.fuelConsumption;
        if(consumedFuel <= fuel){
            this.fuel-=consumedFuel;
        }
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
