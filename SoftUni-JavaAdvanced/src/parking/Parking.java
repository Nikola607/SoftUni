package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            data.add(car);
            this.capacity--;
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;

        for (Car e : data) {
            if (car == null || car.getYear() < e.getYear()) {
                car = e;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        System.out.println("The cars are parked in " + this.type + ":");

        for (Car e : data) {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
