package level6;

import level6.module.config.ChampFactory;
import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.impl.Bow;
import level6.module.domain.weapon.impl.FireWand;
import level6.module.domain.weapon.impl.IceWand;
import level6.module.domain.weapon.impl.Sword;

public class Application {
    public static void main(String[] args) {
        Champ swordWarrior = ChampFactory.createChampFrom("칼전사");
        swordWarrior.attack();
        swordWarrior.changeWeapon(Bow.newInstance());
        swordWarrior.attack();

        Champ bowWarrior = ChampFactory.createChampFrom("활전사");
        bowWarrior.attack();
        bowWarrior.changeWeapon(Sword.newInstance());
        bowWarrior.attack();

        Champ fireWizard = ChampFactory.createChampFrom("불마법사");
        fireWizard.attack();
        fireWizard.changeWeapon(IceWand.newInstance());
        fireWizard.attack();

        Champ iceWizard = ChampFactory.createChampFrom("얼음마법사");
        iceWizard.attack();
        iceWizard.changeWeapon(FireWand.newInstance());
        iceWizard.attack();
    }
}
