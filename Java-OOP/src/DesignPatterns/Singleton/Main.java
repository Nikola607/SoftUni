package DesignPatterns.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> capitals = new HashMap<>();

        String data = scan.nextLine();
        while(!data.equals("Stop")){
            int population = Integer.parseInt(scan.nextLine());
            capitals.put(data, population);

            SingletonDataContainer instance = SingletonDataContainer.getInstance();
            System.out.println(instance.getPopulation(capitals, data));

            data = scan.nextLine();
        }
    }
}
