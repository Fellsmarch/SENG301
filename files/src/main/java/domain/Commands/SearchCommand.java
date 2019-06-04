package domain.Commands;

import domain.Character;
import service.Command;

public class SearchCommand implements Command {

    private Character character;

    public SearchCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.search();
    }
}
