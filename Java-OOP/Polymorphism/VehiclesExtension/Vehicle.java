package Polymorphism.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity (fuelQuantity);
        setFuelConsumption (fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    protected void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    protected void drive(double kilometers) {
        DecimalFormat decimal = new DecimalFormat("#.##");
        if (this.fuelQuantity < this.fuelConsumption * kilometers) {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        } else {
            this.fuelQuantity -= this.fuelConsumption * kilometers;
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(), decimal.format(kilometers));
        }
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
    public String toString() {
        return String.format("%s: %.2f\n", getClass().getSimpleName(), getFuelQuantity());
    }
}
