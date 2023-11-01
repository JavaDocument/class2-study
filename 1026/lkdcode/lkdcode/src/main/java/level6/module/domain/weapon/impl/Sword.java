package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class Sword extends AbstractWeapon {
    private static final String NAME = "칼";
    private static final int DAMAGE = 20;

    private Sword() {
    }

    public static Sword newInstance() {
        return new Sword();
    }

    @Override
    protected int getWeaponDamage() {
        return DAMAGE;
    }

    @Override
    protected String getWeaponName() {
        return NAME;
    }
}
