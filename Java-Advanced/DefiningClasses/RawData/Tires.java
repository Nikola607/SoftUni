package DefiningClasses.RawData;

public class Tires {
    private int age;
    private double pressure;

    public Tires(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }
}
