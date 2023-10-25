package level6.module.domain.weapon.abs;

import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.inter.Weapon;

public abstract class AbstractWeapon implements Weapon {

    @Override
    public void attack(Champ champ, Weapon weapon) {
        String characterClassName = champ.getClass().getSimpleName();
        String weaponName = weapon.getClass().getSimpleName();

        int champDamage = champ.getChampDamage();
        int weaponDamage = getWeaponDamage();
        int totalDamage = weaponDamage * champDamage;

        StringBuilder message = new StringBuilder();

        message.append(characterClassName).append("(이)가 ")
                .append(weaponName).append("(으)로 공격합니다.")
                .append(System.lineSeparator());
        message.append("데미지 : ").append(characterClassName)
                .append("기본 공격력(").append(champDamage).append(") * ")
                .append(weaponName).append(" 공격력(").append(weaponDamage)
                .append(") => ").append(totalDamage)
                .append(System.lineSeparator());

        System.out.println(message);
    }

    protected abstract int getWeaponDamage();
}
