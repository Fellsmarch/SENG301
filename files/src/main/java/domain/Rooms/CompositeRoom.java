package domain.Rooms;

import java.util.ArrayList;
import java.util.List;
import service.Enemy;
import service.Room;
import service.Treasure;

//Task 7
public class CompositeRoom extends Room {

    private Treasure treasure;
    private Enemy enemy;

    /**
     * The list of rooms.
     * I used an ArrayList as I wanted it in order so that the user could always know which room
     * will return the treasure/enemy/whatever, otherwise I would've used a Set (probably HashSet)
     */
    private List<Room> rooms = new ArrayList<>();

    private boolean searched = false;

    /**
     * Returns the first treasure contained in a room in the list of rooms.
     *
     * @return Enemy
     */
    @Override
    public Treasure getTreasure() {
        if (!searched) {
            for (Room room : rooms) {
                treasure = room.getTreasure();
                if (treasure != null) {
                    break;
                }
            }

            //Removed so that what the user found wont print twice, but this might be needed if the
            //print statements are changed to print nicer
//            if (treasure != null) {
//                treasure.revealTreasure();
//            }
            searched = true;
        } else {
            super.getTreasure();
        }

        return treasure;
    }

    /**
     * Returns the first enemy contained in a room in the list of rooms.
     *
     * @return Enemy
     */
    @Override
    public Enemy getEnemy() {
        for (Room room : rooms) {
            enemy = room.getEnemy();

            if (enemy != null) {
                break;
            }
        }

        return enemy;
    }

    @Override
    public String toString() {
        return "Composite Room";
    }

    /**
     * Adds a room to the list of rooms
     *
     * @param room the room to add
     * @return True if added, false if not
     */
    @Override
    public boolean add(Room room) {
        searched = false;
        return rooms.add(room);
    }

    /**
     * Removes a room to the list of rooms
     *
     * @param room the room to remove
     * @return True if removed, false if not
     */
    @Override
    public boolean remove(Room room) {
        searched = false;
        return rooms.remove(room);
    }

}
