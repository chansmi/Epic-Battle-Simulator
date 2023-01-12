// @JNO - what is the Java doc here?

// Character abstract class extended here by the Hero class

/**
 * A type of Character that can attackWithWeapon and specAttackWithWeapon
 * @author s6278
 *
 */
public class Hero extends Character {

	/**
	 * Hero constructor
	 */
	public Hero() {
		super();
	}

	/**
	 * Hero constructor w/ name, hitpoints, strength
	 * @param name
	 * @param hitPoints
	 * @param strength
	 */
	public Hero(String name, int hitPoints, int strength) {
		super(name, hitPoints, strength);
	}

	/**
	 *Hero constructor w/ name, hitpoints, strength, mana
	 *  @param name
	 * @param hitPoints
	 * @param strength
	 * @param mana
	 */
	public Hero(String name, int hitPoints, int strength, int mana) {
		super(name, hitPoints, strength, mana);
	}

	/** Hero constructor w/ name, hitpoints, strength, weapon
	 * @param name
	 * @param hitPoints
	 * @param strength
	 * @param weapon
	 */
	public Hero(String name, int hitPoints, int strength,
				Weapon weapon) { super(name, hitPoints, strength, weapon);}

	/** Hero constructor w/ name, hitpoints, strength, weapon, mana
	 * @param name
	 * @param hitPoints
	 * @param strength
	 * @param mana
	 * @param weapon
	 */
	public Hero(String name, int hitPoints, int strength, int mana,
				Weapon weapon) {
		super(name, hitPoints, strength, mana, weapon);
	}


	@Override
	public int attackWithWeapon() {
		int attack = this.attack();

		if (this.getWeapon() instanceof Magic) {
			int cost = ((Magic) this.getWeapon()).getManaCost();
			if (this.getMana() >= cost) {
				this.setMana(this.getMana() - cost);
				return 2 * this.getWeapon().getDamage();
			} else
				return attack;
		} else
			return attack + this.getWeapon().getDamage();
	}

	/**
	 * @return Special attack! Kapow
	 */
	public int specAttackWithWeapon() {
		if (this.getWeapon() instanceof Barehanded) {
			return this.attack();
		} else if (this.getWeapon() instanceof Melee) {
			return this.getStrength() + this.getWeapon().getSpecDamage();
		} else if (this.getWeapon() instanceof Ranged) {
			return this.getStrength() / 4 + this.getWeapon().getSpecDamage();
		} else {
			int cost = 3 * ((Magic) this.getWeapon()).getManaCost();
			if (this.getMana() >= cost) {
				this.setMana(this.getMana() - cost);
				return this.getWeapon().getDamage()
						+ this.getWeapon().getSpecDamage();
			} else
				return this.getStrength();
		}
	}
}
