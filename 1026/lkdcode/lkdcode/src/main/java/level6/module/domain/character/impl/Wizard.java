package level6.module.domain.character.impl;

import level6.module.domain.character.abs.AbstractChamp;
import level6.module.domain.weapon.impl.FireWand;
import level6.module.domain.weapon.inter.Weapon;

public class Wizard extends AbstractChamp {

    @Override
    public int getChampDamage() {
        return 5;
    }

    @Override
    protected Weapon initializeWeapon() {
        return new FireWand();
    }
}
