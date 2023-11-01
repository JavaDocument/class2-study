package level6.module.domain.weapon.impl;

import level6.module.domain.weapon.abs.AbstractWeapon;

public class Bow extends AbstractWeapon {
    private static final String NAME = "활";
    private static final int DAMAGE = 100;
    private Bow() {
    }

    public static Bow newInstance() {
        ///////////////////////////////
        //------------------------------------------------------
        //   2 3 4 5 6 1
        //------------------------------------------------------


        // 0000000000000000 000000000000000000
        // 0000000000000000 000000000000000000

        // 0000000000000000 000000000000000000
        // 0000000000000000 000000000000000000


        // 1111111
        // 1111111
        // 1111111

        // n * m
        // 0000000
        // 0000000
        // 0000000

        // 0

        // 00
        // 00

        // 0000
        // 0000

        /// 0000
        /// 0000
        /// 0000
        /// 0000



        // queue.add(queue.poll();
        return new Bow();
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
