package DesignPatterns.CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class ModifyPrice {
    private final List<Command> commandList;
    private Command command;

    public ModifyPrice() {
        this.commandList = new ArrayList<Command>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        this.commandList.add(this.command);
        this.command.executeCommand();
    }
}
