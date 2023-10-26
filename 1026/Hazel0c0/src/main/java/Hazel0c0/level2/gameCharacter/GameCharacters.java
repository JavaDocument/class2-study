package Hazel0c0.level2.gameCharacter;

import Hazel0c0.level2.weapon.Weapon;

import static Hazel0c0.level2.weapon.Kind.칼;

public abstract class GameCharacters {
  protected String job;
  protected String weapon;
  protected int basicPower;
  protected int weaponPower;

  public GameCharacters() {
    this.job = "무직";
    this.basicPower = 0;
  }

  // 무기
  public void setWeapon(Weapon weapon){
    this.weapon=weapon.getKind();
    this.weaponPower=weapon.getPower();
  };

  // 공격
  public void attack(){
    System.out.println(job+"(이)가 " + weapon + "(으)로 공격합니다.");
    System.out.println
        (job+" 기본공격력("+ basicPower +") * "+weapon+" 공격력("+weaponPower+") " +
        "=> "+(basicPower*weaponPower));
  };
}
