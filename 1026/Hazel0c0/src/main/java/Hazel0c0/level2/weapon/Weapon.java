package Hazel0c0.level2.weapon;

import static Hazel0c0.level2.weapon.Kind.칼;

public abstract class Weapon {

  protected Kind kind;
  protected int power;

  public String getKind(){
    return String.valueOf(kind);
  };
  public int getPower(){
    return power;
  }
}
