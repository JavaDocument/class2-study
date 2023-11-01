package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class IceWand extends AbstractWeapon {
    private static final String NAME = "얼음지팡이";
    private static final int DAMAGE = 60;

    private IceWand() {
    }

    public static IceWand newInstance() {
        return new IceWand();
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
