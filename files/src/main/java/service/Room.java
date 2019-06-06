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

    public boolean add(Room room) {
        return false;
    }

    public boolean remove(Room room) {
        return false;
    }
}
