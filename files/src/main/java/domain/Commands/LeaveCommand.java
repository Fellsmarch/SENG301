package domain.Commands;

import domain.Character;
import service.Command;

public class LeaveCommand implements Command {

    private Character character;

    public LeaveCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.leave();
    }
}
