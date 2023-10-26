package level6.module.domain.character.impl;

import level6.module.domain.character.abs.AbstractChamp;
import level6.module.domain.weapon.inter.Weapon;

public class Wizard extends AbstractChamp {
    private static final int DAMAGE = 5;
    private Weapon weapon;

    private Wizard(Weapon weapon) {
        this.weapon = weapon;
    }

    public static Wizard from(Weapon weapon) {
        return new Wizard(weapon);
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
