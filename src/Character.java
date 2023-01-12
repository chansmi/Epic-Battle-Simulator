// Character class extended to Hero and Villian

import java.util.Random;

/**
 * Character class
 * Generic RPG Character
 */
public abstract class Character
{
	private String name;
	private int hitPoints;
	private int strength;
	private int mana;
	private Weapon weapon;

	/**
	 * Character constructor
	 */
	public Character() {
		this.name = "John Doe";
		this.hitPoints = 100;
		this.strength = 20;
		this.mana = 0;
		this.weapon = new Barehanded();
	}

	/**
	 * Character constructor w/ name, hitpoints, and strength
	 * @param name
	 * @param hitPoints
	 * @param strength
	 */
	public Character(String name, int hitPoints, int strength) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.mana = 0;
		this.weapon = new Barehanded();
	}

	/**
	 * Character constructor w/ name, hitpoints, strength, mana
	 * @param name
	 * @param hitPoints
	 * @param strength
	 * @param mana
	 */
	public Character(String name, int hitPoints, int strength, int mana) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.mana = mana;
		this.weapon = new Barehanded();
	}

	/**
	 * 	 * Character constructor w/ name, hitpoints, strength, mana, weapon
	 * @param name
	 * @param hitPoints
	 * @param strength
	 * @param mana
	 * @param weapon
	 */
	public Character(String name, int hitPoints, int strength,
					 int mana, Weapon weapon) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.mana = mana;
		this.weapon = weapon;
	}

	/**
	 * 	 * Character constructor w/ name, hitpoints, strength, weapon
	 * @param name
	 * @param hitPoints
	 * @param strength
	 * @param weapon
	 */
	public Character(String name, int hitPoints, int strength,
					 Weapon weapon) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.mana = 0;
		this.weapon = weapon;
	}


	// setters
	/**
	 * Assigns new value to character hitPoints
	 *
	 * @param hitPoints
	 */
	public void setHitPoints(int hitPoints) {
		if (hitPoints <=0) {
			this.hitPoints = 0;
		} else {
			this.hitPoints=hitPoints;
		}
	}
	public void setMana(int mana) {this.mana = mana;}
	public void setWeapon(Weapon weapon) {this.weapon = weapon;}


	/**
	 * @return name
	 */
	// getters
	public String getName() {return name;}

	/**
	 * @return hitPoints
	 */
	public int getHitPoints() {return hitPoints;}

	/**
	 * @return strength
	 */
	public int getStrength() {return strength;}

	/**
	 * @return mana
	 */
	public int getMana() {return mana;}

	/**
	 * @return weapon
	 */
	public Weapon getWeapon() {return this.weapon;}

	/**
	 * @return boolean
	 */
	public boolean isAlive() {return hitPoints > 0;}

	/**
	 * take damage method
	 * @param damage
	 */
	/* reduces character hitPoints by specified amount */
	public void takeDamage(int damage) {
		setHitPoints(this.hitPoints - damage);
	}

	/**
	 * @return attack
	 */
	/* gets a random integer between 0 and character strength */
	public int attack() {
		Random rand = new Random();
		int attack = 0;
		// protected with try/catch to prevent 0 strength throwing error
		// and to prevent spagettification
		try {
			attack = rand.nextInt(strength);
		} catch (IllegalArgumentException IVE) {
			attack = 0;
		}
		return attack;
	}

	/**
	 * @return attack with weapon
	 */
	public int attackWithWeapon() {
		int attack = this.attack();
		return attack + this.weapon.getDamage();
	}

	/**
	 * @return toString
	 */
	public String toString() {
		return "Name: " + name + "  HitPoints: " + hitPoints
				+ "\n" + weapon;
	}

}
