package ExamPreparation.bakery.entities.tables;

import ExamPreparation.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation.bakery.entities.drinks.interfaces.Drink;
import ExamPreparation.bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPreparation.bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private final Collection<BakedFood> foodOrders;
    private final Collection<Drink> drinkOrders;

    private final int tableNumber;
    private int capacity;
    private final double pricePerPerson;

    private int numberOfPeople;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.setReserved(false);
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.price = getPricePerPerson() * getNumberOfPeople();

        setReserved(true);
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double foodBill = foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        double drinkBill = drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        return foodBill + drinkBill + this.getPrice();
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        setReserved(false);
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %s\n" +
                "Type: %s\n" +
                "Capacity: %s\n" +
                "Price per Person: %.2f", getTableNumber(), getClass().getSimpleName(),
                getCapacity(), getPricePerPerson()
        );
    }
}
