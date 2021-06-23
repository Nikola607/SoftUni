package ExamPreparation.bakery;

import ExamPreparation.bakery.core.ControllerImpl;
import ExamPreparation.bakery.core.EngineImpl;
import ExamPreparation.bakery.core.interfaces.Controller;
import ExamPreparation.bakery.entities.bakedFoods.interfaces.BakedFood;
import ExamPreparation.bakery.entities.drinks.interfaces.Drink;
import ExamPreparation.bakery.entities.tables.interfaces.Table;

import ExamPreparation.bakery.io.ConsoleReader;
import ExamPreparation.bakery.io.ConsoleWriter;
import ExamPreparation.bakery.repositories.DrinkRepositoryImpl;
import ExamPreparation.bakery.repositories.FoodRepositoryImpl;
import ExamPreparation.bakery.repositories.TableRepositoryImpl;
import ExamPreparation.bakery.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
