package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void refuel(double liters){
        this.fuelQuantity+=liters;
    }

    public void drive(double distance){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(this.fuelQuantity < this.fuelConsumption * distance){
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }else{
            this.fuelQuantity-=this.fuelConsumption * distance;
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(), decimalFormat.format(distance));
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String toString(){
        return String.format("%s: %.2f\n", getClass().getSimpleName(), getFuelQuantity());
    }
}
