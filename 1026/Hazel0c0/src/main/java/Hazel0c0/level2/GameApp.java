package Hazel0c0.level2;

import Hazel0c0.level2.gameCharacter.GameCharacters;
import Hazel0c0.level2.gameCharacter.Warrior;
import Hazel0c0.level2.weapon.Bow;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApp {

	public static void main(String[] args) {
		GameCharacters 짱짱쎄 = new Warrior();

		짱짱쎄.attack();

		짱짱쎄.setWeapon(new Bow());

		짱짱쎄.attack();
	}

}
