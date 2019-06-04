package domain;

import service.Room;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Contains methods that to interact with the current board state.
 */
public class Board {

    private static Board board;
    private Room currentRoom;

    private Set<Room> rooms = new HashSet<>();
    private Boolean gameOver = false;

    private Set<Room> visitedRooms = new HashSet<>();

    private void Board() {

    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Boolean allRoomsVisited() {
        return rooms.size() == visitedRooms.size();
    }

    /**
     * Checks if the room has been visited.
     * Sets the new current room.
     * @param room Randomly generated new room.
     */
    public void setCurrentRoom(Room room) {
        if (!visitedRooms.contains(room)) {
            currentRoom = room;
        } else {
            changeRoom();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Chooses a new random room to move to.
     */
    public void changeRoom() {
        int size = rooms.size();
        if (size != visitedRooms.size()) {
            int item = new Random().nextInt(size);
            int index = 0;
            for (Room room : rooms) {
                if (index == item) {
                    visitedRooms.add(currentRoom);
                    setCurrentRoom(room);
                }
                index++;
            }
        }
    }

    /**
     * Sets gameOver to true.
     */
    public void endGame() {
        gameOver = true;
    }

    /**
     * Checks whether the game is over.
     * @return gameOver.
     */
    public Boolean isGameOver() {
        return gameOver;
    }

    /**
     * Gets the board.
     * @return Board.
     */
    public static Board getBoard() {
        if (board != null) {
            return board;
        } else {
            board = new Board();
            return board;
        }
    }
}
