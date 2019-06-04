package domain.Rooms;

import service.Room;
import service.Treasure;

/**
 * A treasure room that contains just one treasure.
 */
public class TreasureRoom extends Room {

    private Treasure treasure;
    private Boolean searched = false;

    public TreasureRoom(Treasure treasure) {
        this.treasure = treasure;
    }

    /**
     * Reveals the treasure contained in the room.
     * @return Treasure.
     */
    @Override
    public Treasure getTreasure() {
        if (!searched) {
            treasure.revealTreasure();
            searched = true;
        } else {
            super.getTreasure();
        }

        return treasure;
    }

    /**
     * Enters the room.
     */
    @Override
    public void enter() {
        super.enter();
    }

    @Override
    public String toString() {
        return "Treasure room";
    }
}
