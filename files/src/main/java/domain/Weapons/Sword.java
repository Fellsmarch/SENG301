package domain.Weapons;

import service.Weapon;

public class Sword implements Weapon {

    /**
     * Attack method for the sword.
     */
    @Override
    public String swing() {
        return "swings at you with " + this;
    }

    @Override
    public String toString() {
        return "Sword";
    }
}
