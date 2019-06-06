package service;

/**
 * Room class containing methods similar to all rooms.
 */
public abstract class Room {

    /**
     * Reveals the treasure located within the room
     * @return treasure object
     */
    public Treasure getTreasure() {
        System.out.println("There is no more treasure in this room");
        //return no treasure
        return null;
    }

    /**
     * Gets the enemy located in a room.
     * @return Enemy object
     */
    public Enemy getEnemy() {
        return null;
    }

    /**
     * Prints out that the room has been entered.
     */
    public void enter() {
        System.out.println("You have entered a " + this);
    }

    /**
     * The add method for the Composite pattern
     *
     * @param room the room to add
     * @return True if added, false if not
     */
    public boolean add(Room room) {
        return false;
    }

    /**
     * The remove method for the Composite pattern
     *
     * @param room the room to remove
     * @return True if removed, false if not
     */
    public boolean remove(Room room) {
        return false;
    }
}
