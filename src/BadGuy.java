//Character abstract class extended here by the BadGuy class

import java.util.Random;

/**
 * Bad guy class which extends character
 * @return a bad guy!
 */
public class BadGuy extends Character {
	static String[] phrases = {
			" You will die!",
			" Prepare to die!",
			" Perish, brief mortal!",
			" I will break you!",
			" Ahaha! Ahahahahahaha!",
			" That puny strength will never be enough to stop me. Die!",
			" Do you fear death?",
			" I will tear you limb from limb!",
			" Fool! I cannot be defeated!",
			" You cannot stop me. Perish!"
	};
	/**
	 * Bad guy constructor
	 * @return a bad guy!
	 */
	public BadGuy() {
		super();
	}

	/**
	 * Bad guy constructor
	 * @return a bad guy!
	 * @param hitPoints
	 * @param name
	 * @param strength
	 */
	public BadGuy(String name, int hitPoints, int strength) {
		super(name, hitPoints, strength);
	}

	/**
	 * Bad guy constructor
	 * @return a bad guy!
	 * @param hitPoints
	 * @param name
	 * @param strength
	 * @param mana
	 */
	public BadGuy(String name, int hitPoints, int strength, int mana) {
		super(name, hitPoints, strength, mana);
	}

	/**
	 * Bad guy constructor
	 * @return a bad guy!
	 * @param hitPoints
	 * @param name
	 * @param strength
	 * @param weapon
	 */
	public BadGuy(String name, int hitPoints, int strength,
				  Weapon weapon) {
		super(name,hitPoints,strength, weapon);
	}
	/**
	 * Bad guy constructor
	 * @return a bad guy!
	 * @param hitPoints
	 * @param name
	 * @param strength
	 * @param mana
	 * @param weapon
	 */
	public BadGuy(String name, int hitPoints, int strength, int mana,
				  Weapon weapon) {
		super(name, hitPoints, strength, mana, weapon);
	}

	/**
	 * Bad guy speak
	 * @return a bad guy speak
	 */
	public String speak() {
		Random phrase = new Random();
		return phrases[phrase.nextInt(phrases.length)];
	}

	@Override
	public int attack() {
		System.out.println("\n" + this.getName() + " says:" + this.speak());
		return super.attack();
	}
}
