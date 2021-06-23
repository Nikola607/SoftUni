package Reflection.barracksWars;

import Reflection.barracksWars.interfaces.Repository;
import Reflection.barracksWars.interfaces.Runnable;
import Reflection.barracksWars.interfaces.UnitFactory;
import Reflection.barracksWars.core.Engine;
import Reflection.barracksWars.core.factories.UnitFactoryImpl;
import Reflection.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
