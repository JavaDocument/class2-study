package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class Bow extends AbstractWeapon {
    private static final String NAME = "활";

    private Bow() {
    }

    public static Bow newInstance() {
        return new Bow();
    }

    @Override
    protected int getWeaponDamage() {
        return 100;
    }

    @Override
    protected String getWeaponName() {
        return NAME;
    }
}
