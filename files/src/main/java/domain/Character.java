package domain;

import java.util.ArrayList;
import java.util.Observable;
import service.Enemy;
import service.Treasure;

import java.util.List;

/**
 * Contains basic methods of a character.
 */
public class Character extends Observable { //Task 5

    private static final int ALIVE = 0;
    private static final int DEAD = 1;
    private static final int READY = 2;
    private static final int IN_COMBAT = 3;

    private int state = ALIVE;

    //Task 5

    private List<Treasure> collectedTreasures = new ArrayList<>(); //Task 2

    /**
     * Searches the current room for a treasure.
     */
    public void search() {
        Treasure treasure = Board.getBoard().getCurrentRoom().getTreasure();
        if (treasure != null) {
            collectedTreasures.add(Board.getBoard().getCurrentRoom().getTreasure());
        }
    }

    /**
     * Enters a new pre-determined room.
     */
    public void enter() {
        Board.getBoard().getCurrentRoom().enter();
        prepare();
    }

    /**
     * Leaves the current room.
     */
    public void leave() {
        if (Board.getBoard().getCurrentRoom().getEnemy() != null) {
            removeEnemy(Board.getBoard().getCurrentRoom().getEnemy());
        }
    }

    /**
     * Changes the state of the character to ready.
     */
    public void prepare() {
        changeState(READY);
    }

    /**
     * Changes the state of the character to dead.
     */
    public void kill() {
        changeState(DEAD);
        System.out.println("You have died!");
        Board.getBoard().endGame();
    }

    /**
     * Changes the state of the character to in combat.
     */
    public void fight() {
        changeState(IN_COMBAT);
    }

    /**
     * Changes the state of the character to alive.
     */
    public void rest() {
        changeState(ALIVE);
        System.out.println("You have survived the attack!");
    }

    /**
     * Checks whether the character is in a ready state.
     */
    public boolean isReady() {
        return state == READY;
    }

    /**
     * Changes the state of the character.
     * @param state
     */
    private void changeState(int state) {
        this.state = state;
        setChanged();
        notifyObservers(); //Task 5
    }

    //Task 2
    public List<Treasure> getCollectedTreasures() {
        return collectedTreasures;
    }

    public void addEnemy(Enemy e) {
        addObserver(e); //Task 5
    }

    private void removeEnemy(Enemy e) {
        deleteObserver(e); //Task 5
    }

    //Task 5

}
