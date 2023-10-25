package level6;

import level6.module.domain.character.impl.Warrior;
import level6.module.domain.character.impl.Wizard;
import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.impl.Bow;
import level6.module.domain.weapon.impl.Sword;

public class Application {
    public static void main(String[] args) {
        Champ champ = new Warrior();
        champ.attack();

        champ.changeWeapon(new Bow());
        champ.attack();

        Champ champ1 = new Wizard();
        champ1.attack();

        champ1.changeWeapon(new Sword());
        champ1.attack();
    }
}
