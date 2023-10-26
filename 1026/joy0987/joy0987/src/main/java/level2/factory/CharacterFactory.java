package main.java.level2.factory;

import main.java.level2.character.Character;
import main.java.level2.character.Warrior;
import main.java.level2.character.Wizard;
import main.java.level2.weapon.Bow;
import main.java.level2.weapon.IceStick;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

    private final static Map<String, Character> characters = new HashMap<>();

    public static Character get(String type) {
        if (characters.containsKey(type)) {
            return characters.get(type);
        }

        Character character = createCharacter(type);
        characters.put(type, character);
        return character;
    }

    public static Character createCharacter(String type) {
        switch (type) {
            case "칼전사" -> {
                return new Warrior();
            }
            case "활전사" -> {
                return new Warrior(new Bow());
            }
            case "불마법사" -> {
                return new Wizard();
            }
            case "얼음마법사" -> {
                return new Wizard(new IceStick());
            }
            default -> {
                throw new IllegalArgumentException("올바른 타입을 입력하세요");
            }
        }
    }
}
