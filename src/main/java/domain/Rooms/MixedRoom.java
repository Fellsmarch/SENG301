package domain.Rooms;

import service.Enemy;
import service.Room;
import service.Treasure;

/**
 * A mixed room that contains both an enemy and a treasure.
 */
public class MixedRoom extends Room {
    private Enemy enemy;
    private Treasure treasure;
    private Boolean searched = false;

    /**
     * Adds an enemy and treasure to the room.
     * @param enemy
     * @param treasure
     */
    public MixedRoom(Enemy enemy, Treasure treasure) {
        this.enemy = enemy;
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
     * Gets the enemy contained in the room.
     * @return enemy.
     */
    @Override
    public Enemy getEnemy() {
        return enemy;
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
        return "Mixed room";
    }
}
