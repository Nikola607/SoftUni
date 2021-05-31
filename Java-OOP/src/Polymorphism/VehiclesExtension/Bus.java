package Polymorphism.VehiclesExtension;

public class Bus extends Vehicle{
    private boolean isEmpty = false;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption){
        if(isEmpty){
            super.setFuelConsumption(fuelConsumption);
        }else{
            super.setFuelConsumption(fuelConsumption + 1.4);
        }
    }
}
