package service;

import domain.Board;
import domain.Character;

import java.util.Observable;
import java.util.Random;
import java.util.Observer;

/**
 * Contains methods that enemies have in common.
 */
public abstract class Enemy implements Observer { //Task 5

    /**
     * Attacks a character.
     * @param character Character to be attacked.
     */
    private void attack(Character character) {
        System.out.println(this + " " + createWeapon().swing());
        createWeapon().swing();

        //randomly choose winner and update state
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10);
        if (randomInt > 7) {
            //enemy won.
            character.kill();
        } else {
            character.rest();
        }
    }

    /**
     * Creates a weapon for the enemy.
     * @return Weapon.
     */
    protected abstract Weapon createWeapon();

    public void update(Observable o, Object arg) { //Task 5
        Character character = (Character) o; //Task 5
        if (Board.getBoard().getCurrentRoom().getEnemy() == this && character.isReady()) { //Task 5
            character.fight();
            attack(character);
        }
    }
}
