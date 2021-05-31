package DefiningClasses.CarSalseman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int engineNum = Integer.parseInt(scan.nextLine());

        Map<String, Engine> engineMap = new LinkedHashMap<>();

        while (engineNum-- > 0) {
            String[] data = scan.nextLine().split("\\s+");

            String model = data[0];
            int power = Integer.parseInt(data[1]);

            Engine engine = null;

            if (data.length == 4) {
                int displacement = Integer.parseInt(data[2]);
                String efficiency = data[3];

                engine = new Engine(model, power, displacement, efficiency);
            }else if(data.length == 2){
                engine = new Engine(model, power);
            }else if(data.length == 3){
                if(data[2].matches("\\d+")){
                    int displacement = Integer.parseInt(data[2]);

                    engine = new Engine(model, power, displacement);
                }else{
                    String efficiency = data[2];

                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.putIfAbsent(model, engine);
        }

        int carNum = Integer.parseInt(scan.nextLine());

        List<Car> carList = new ArrayList<>();

        while (carNum-- > 0){
            String[] data = scan.nextLine().split("\\s+");

            String model = data[0];
            Engine engine = engineMap.get(data[1]);

            Car car = null;

            if(data.length == 4){
                int weight = Integer.parseInt(data[2]);
                String color = data[3];

                car = new Car(model, engine, weight, color);
            }else if(data.length == 2){
                car = new Car(model, engine);
            }else if(data.length == 3){
                if(data[2].matches("\\d+")){
                    int weight = Integer.parseInt(data[2]);

                    car = new Car(model, engine, weight);
                }else{
                    String color = data[2];

                    car = new Car(model, engine, color);
                }
            }
            carList.add(car);
        }

        carList.stream().
                forEach(e -> System.out.println(e));
    }
}
