package domain.Enemies;

import domain.Weapons.Sword;
import service.Enemy;
import service.Weapon;

import java.util.Observable;

public class Ninja extends Enemy {

    /**
     * Creates a new weapon for the ninja.
     * @return a weapon
     */
    @Override
    protected Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public String toString() {
        return "Ninja";
    }
}
