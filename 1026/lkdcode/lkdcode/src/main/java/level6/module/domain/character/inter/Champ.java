package level6.module.domain.character.inter;

import level6.module.domain.weapon.inter.Weapon;

public interface Champ {
    void attack();

    void changeWeapon(Weapon weapon);

    int getChampDamage();
}
