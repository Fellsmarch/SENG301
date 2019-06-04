package domain.Weapons;

import service.Weapon;

public class Hammer implements Weapon {

    /**
     * Attack method for the hammer.
     */
    @Override
    public String swing() {
        return "hits you with " + this;
    }

    @Override
    public String toString() {
        return "Hammer";
    }
}
