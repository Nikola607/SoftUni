package ExamPreparation.bakery.core;

import ExamPreparation.bakery.core.interfaces.Controller;
import ExamPreparation.bakery.entities.bakedFoods.Bread;
import ExamPreparation.bakery.entities.bakedFoods.Cake;
import ExamPreparation.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation.bakery.entities.drinks.Tea;
import ExamPreparation.bakery.entities.drinks.Water;
import ExamPreparation.bakery.entities.drinks.interfaces.Drink;
import ExamPreparation.bakery.entities.tables.InsideTable;
import ExamPreparation.bakery.entities.tables.OutsideTable;
import ExamPreparation.bakery.entities.tables.interfaces.Table;
import ExamPreparation.bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

import static ExamPreparation.bakery.common.ExceptionMessages.*;
import static ExamPreparation.bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private final FoodRepository<BakedFood> foodRepository;
    private final DrinkRepository<Drink> drinkRepository;
    private final TableRepository<Table> tableRepository;

    private double totalBills;
    private BakedFood food;
    private Drink drink;
    private Table table;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addFood(String type, String name, double price) {
        if (this.foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Bread":
                food = new Bread(name, price);
                break;
            case "Cake":
                food = new Cake(name, price);
                break;
        }

        foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (this.drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                break;
        }

        drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                break;
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        table = tableRepository.getAll().stream().filter(e -> (!e.isReserved() && (e.getCapacity() >= numberOfPeople))).
                findFirst().orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        if (tableRepository.getByNumber(tableNumber) == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (foodRepository.getByName(foodName) == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        tableRepository.getByNumber(tableNumber).orderFood(foodRepository.getByName(foodName));
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        if (tableRepository.getByNumber(tableNumber) == null ) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (drinkRepository.getByNameAndBrand(drinkName, drinkBrand) == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        tableRepository.getByNumber(tableNumber).orderDrink(drinkRepository.getByNameAndBrand(drinkName, drinkBrand));
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        double bill = tableRepository.getByNumber(tableNumber).getBill();
        totalBills += bill;

        tableRepository.getByNumber(tableNumber).clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();

        List<Table> freeTables = tableRepository.getAll().stream().
                filter(e -> (!e.isReserved())).
                collect(Collectors.toList());

        freeTables.forEach(e ->
                sb.append(e.getFreeTableInfo()).append(System.lineSeparator()));

        return sb.toString();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, totalBills);
    }
}
