package service;

import domain.Character;

import java.util.Random;

/**
 * Contains methods that enemies have in common.
 */
public abstract class Enemy {

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

    public void add(Character character) {
        if (character.isReady()) {
            character.fight();
            attack(character);
        }
    }
}
