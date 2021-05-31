package DefiningClasses.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tires[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public boolean tiresCheck(){
        for(Tires tire : tires){
            if(tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires[] getTires() {
        return tires;
    }

    @Override
    public String toString(){
       return model;
    }
}
