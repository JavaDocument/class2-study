package main.java;

import main.java.level2.character.Character;
import main.java.level2.character.Wizard;
import main.java.level2.factory.CharacterFactory;
import main.java.level2.weapon.Bow;
import main.java.level2.character.Warrior;

public class Application {
    public static void main(String[] args) {
        Character ac = CharacterFactory.get("칼전사");

        ac.attack();

        ac = CharacterFactory.get("활전사");

        ac.attack();

        ac = CharacterFactory.get("불마법사");

        ac.attack();

        ac = CharacterFactory.get("얼음마법사");

        ac.attack();
    }
}
