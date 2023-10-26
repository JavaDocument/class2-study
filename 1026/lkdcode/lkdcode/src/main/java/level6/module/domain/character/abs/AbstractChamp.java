package level6.module.domain.character.abs;

import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.inter.Weapon;

public abstract class AbstractChamp implements Champ {

    @Override
    public void attack() {
        Weapon weapon = getChampWeapon();
        weapon.attack(this);
    }

    protected abstract Weapon getChampWeapon();

}
