package domain.Rooms;

import service.Room;

/**
 * A basic room that contains nothing.
 */
public class BasicRoom extends Room {

    @Override
    public void enter() {
        super.enter();
    }

    @Override
    public String toString() {
        return "Basic room";
    }
}
