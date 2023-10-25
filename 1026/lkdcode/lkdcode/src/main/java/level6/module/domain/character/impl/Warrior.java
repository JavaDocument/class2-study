package level6.module.domain.character.impl;

import level6.module.domain.character.abs.AbstractChamp;
import level6.module.domain.weapon.impl.Sword;
import level6.module.domain.weapon.inter.Weapon;

public class Warrior extends AbstractChamp {

    @Override
    public int getChampDamage() {
        return 10;
    }

    @Override
    protected Weapon initializeWeapon() {
        return new Sword();
    }

}
