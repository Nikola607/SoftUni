package DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPrice;
    int distance = 0;

    public Car(String model, double fuelAmount, double fuelPrice) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPrice = fuelPrice;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public boolean Drive(int kmToDrive){
        double km = kmToDrive * getFuelPrice();
        if(fuelAmount >=km){
            fuelAmount-=km;
            distance+=kmToDrive;

            return true;
        }else{
            System.out.println("Insufficient fuel for the drive");
            return false;
        }
    }
}
