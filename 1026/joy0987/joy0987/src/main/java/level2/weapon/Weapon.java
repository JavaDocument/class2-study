package main.java.level2.weapon;

import main.java.level2.character.Character;

public abstract class Weapon {

    public String name;
    public int power;

    public void attack(String type, int basicPower) {
        System.out.println(type + "(이)가 " + name + "(으)로 공격합니다.");
        System.out.println("데미지 : "
                + type
                + " 기본공격력("
                + basicPower
                + ") * "
                + name
                + " 공격력("
                + power
                + ") => "
                + (basicPower * power));
    }

}
