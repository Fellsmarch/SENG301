package domain.Commands;

import service.Command;

public class Action {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void performAction() {
        command.execute();
    }
}
