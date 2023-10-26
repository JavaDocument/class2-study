package level6.module.config;

import level6.module.domain.character.impl.Warrior;
import level6.module.domain.character.impl.Wizard;
import level6.module.domain.character.inter.Champ;
import level6.module.domain.weapon.impl.Bow;
import level6.module.domain.weapon.impl.FireWand;
import level6.module.domain.weapon.impl.IceWand;
import level6.module.domain.weapon.impl.Sword;

public class ChampFactory {
    private static Champ swordWarrior;
    private static Champ bowWarrior;
    private static Champ fireWizard;
    private static Champ iceWizard;

    private ChampFactory() {
    }

    public static Champ createChampFrom(final String champClassName) {
        switch (champClassName) {
            case "칼전사" -> {
                return createSwordWarrior();
            }
            case "활전사" -> {
                return createBowWarrior();
            }
            case "불마법사" -> {
                return createFireWizard();
            }
            case "얼음마법사" -> {
                return createIceWizard();
            }
            default -> {
                return null;
            }
        }
    }

    private static Champ createSwordWarrior() {
        if (swordWarrior == null) {
            swordWarrior = Warrior.from(Sword.newInstance());
        }
        return swordWarrior;
    }

    private static Champ createBowWarrior() {
        if (bowWarrior == null) {
            bowWarrior = Warrior.from(Bow.newInstance());
        }
        return bowWarrior;
    }

    private static Champ createFireWizard() {
        if (fireWizard == null) {
            fireWizard = Wizard.from(FireWand.newInstance());
        }
        return fireWizard;
    }

    private static Champ createIceWizard() {
        if (iceWizard == null) {
            iceWizard = Wizard.from(IceWand.newInstance());
        }
        return iceWizard;
    }
}
