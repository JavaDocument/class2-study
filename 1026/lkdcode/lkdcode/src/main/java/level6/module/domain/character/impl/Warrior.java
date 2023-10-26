package level6.module.domain.character.impl;

import level6.module.domain.character.abs.AbstractChamp;
import level6.module.domain.weapon.inter.Weapon;

public class Warrior extends AbstractChamp {
    private static final int DAMAGE = 10;
    private Weapon weapon;

    private Warrior(Weapon weapon) {
        this.weapon = weapon;
    }

    public static Warrior from(Weapon weapon) {
        return new Warrior(weapon);
    }

    @Override
    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int getChampDamage() {
        return DAMAGE;
    }

    @Override
    protected Weapon getChampWeapon() {
        return weapon;
    }

}
