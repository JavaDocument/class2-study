package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class Sword extends AbstractWeapon {
    private static final String NAME = "칼";

    private Sword() {
    }

    public static Sword newInstance() {
        return new Sword();
    }

    @Override
    protected int getWeaponDamage() {
        return 20;
    }

    @Override
    protected String getWeaponName() {
        return NAME;
    }
}
