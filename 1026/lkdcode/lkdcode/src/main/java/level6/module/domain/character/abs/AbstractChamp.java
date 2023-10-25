package level6.module.domain.character.abs;

import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.inter.Weapon;

public abstract class AbstractChamp implements Champ {
    private Weapon weapon = initializeWeapon();

    @Override
    public void attack() {
        weapon.attack(this, weapon);
    }

    @Override
    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    protected abstract Weapon initializeWeapon();

}
