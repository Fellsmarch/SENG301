package domain.Enemies;

import domain.Weapons.Hammer;
import service.Enemy;
import service.Weapon;

public class Turtle extends Enemy {

    @Override
    public String toString() {
        return "Turtle";
    }

    /**
     * Creates a new weapon for the turtle.
     * @return a weapon.
     */
    @Override
    protected Weapon createWeapon() {
        return new Hammer();
    }
}
