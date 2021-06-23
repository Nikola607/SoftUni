package Reflection.barracksWarsTheCommandsStrikeBack;

import Reflection.barracksWarsTheCommandsStrikeBack.core.CommandModel;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.CommandInterpreter;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Runnable;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;
import Reflection.barracksWarsTheCommandsStrikeBack.core.Engine;
import Reflection.barracksWarsTheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import Reflection.barracksWarsTheCommandsStrikeBack.data.UnitRepository;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandModel(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
