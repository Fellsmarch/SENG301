//Task 1
package domain.Commands;

import domain.Character;
import service.Command;

public class EnterCommand implements Command {

    private Character character;

    public EnterCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.enter();
    }
}
