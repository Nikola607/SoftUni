package Reflection.barracksWarsTheCommandsStrikeBack.core.commands;

import Reflection.barracksWarsTheCommandsStrikeBack.interfaces.Executable;

public class Fight implements Executable {
    public Fight() {
    }

    @Override
    public String execute() {
        return "fight";
    }
}
