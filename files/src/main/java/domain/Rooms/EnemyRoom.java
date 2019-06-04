package domain.Rooms;

import service.Enemy;
import service.Room;

/**
 * An enemy room that contains just one enemy.
 */
public class EnemyRoom extends Room {
    private Enemy enemy;

    /**
     * Adds an enemy to the room.
     * @param enemy Enemy to be added.
     */
    public EnemyRoom(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Returns the enemy contained in the room.
     * @return Enemy
     */
    @Override
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Enters the current room.
     */
    @Override
    public void enter() {
        super.enter();
    }

    @Override
    public String toString() {
        return "Enemy room";
    }
}
