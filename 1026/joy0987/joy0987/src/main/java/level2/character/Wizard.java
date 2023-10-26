package level2.character;


import level2.weapon.FireStick;
import level2.weapon.Weapon;

public class Wizard extends Character {

    public Wizard() {
        weapon = new FireStick();
        type = "마법사";
        basicPower = 5;
    }

    public Wizard(Weapon weapon) {
        this.weapon = weapon;
        type = "마법사";
        basicPower = 5;
    }
}
