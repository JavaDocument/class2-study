package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class FireWand extends AbstractWeapon {
    private static final String NAME = "불지팡이";

    private FireWand() {
    }

    public static FireWand newInstance() {
        return new FireWand();
    }

    @Override
    protected int getWeaponDamage() {
        return 50;
    }

    @Override
    protected String getWeaponName() {
        return NAME;
    }
}
