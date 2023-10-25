package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class FireWand extends AbstractWeapon {
    @Override
    protected int getWeaponDamage() {
        return 50;
    }
}
