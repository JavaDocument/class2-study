package Hazel0c0.level2.gameCharacter;

import static Hazel0c0.level2.weapon.Kind.칼;

public class Warrior extends GameCharacters {
  public Warrior() {
    super.job="전사";
    super.basicPower=10;
    super.weapon= String.valueOf(칼);
    super.weaponPower=20;
  }
}

