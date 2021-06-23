package ExamPreparation.bakery.entities.tables.interfaces;

import ExamPreparation.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation.bakery.entities.drinks.interfaces.Drink;

public interface Table {
    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();
}
