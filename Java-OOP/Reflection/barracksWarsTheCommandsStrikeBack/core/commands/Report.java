package Reflection.barracksWarsTheCommandsStrikeBack.core.commands;

import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Executable;
import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Repository;

public class Report implements Executable {
    private Repository repository;

    public Report(Repository repository) {
        this.repository = repository;
    }

    public Report() {

    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
