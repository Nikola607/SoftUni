package Reflection.barracksWarsTheCommandsStrikeBack.core.commands;

import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Executable;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Unit;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class Add implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Add() {

    }

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() {
        String unitType = data[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
