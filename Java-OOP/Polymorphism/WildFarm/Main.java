package Polymorphism.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")){
            String[] animalData = input.split("\\s+");
            Animal animal = createAnimal(animalData);

            String[] foodData = scan.nextLine().split("\\s+");
            Food food = createFood(foodData);

            animal.makeSound();

            try{
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            animals.add(animal);
            input = scan.nextLine();
        }

        for(Animal animal : animals){
            System.out.println(animal);
        }
    }

    private static Food createFood(String[] foodData) {
        return foodData[0].equals("Meat") ? new Meat(Integer.parseInt(foodData[1])) : new Vegetable(Integer.parseInt(foodData[1]));
    }

    private static Animal createAnimal(String[] animalData) {
        String type = animalData[0];
        String name = animalData[1];
        double weight =Double.parseDouble(animalData[2]);
        String region = animalData[3];

        Animal animal = null;
        switch (animalData[0]){
            case"Cat":
                animal = new Cat(name, type, weight, region, animalData[4]);
                break;
            case"Tiger":
                animal = new Tiger(name, type, weight, region);
                break;
            case"Zebra":
                animal = new Zebra(name, type, weight, region);
                break;
            case"Mouse":
                animal = new Mouse(name, type, weight, region);
                break;

        }
        return animal;
    }
}
