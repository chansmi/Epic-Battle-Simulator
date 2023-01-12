import java.util.Random;

/**
Weapon class object
*/
abstract public class Weapon {
	public enum TYPE {Melee, Ranged, Magic}
	
	private String name;
	private int maxDamage;
	private int durability;
	private TYPE type;


	/**
	 * Weapon constructor
	 */
	// constructors
	public Weapon() {
		this.name = "Barehanded";
		this.maxDamage = 0;
		this.durability = 0;
		this.type = TYPE.Melee;
	}

	/**
	 * Weapon constructor with name, Max Damage, and durability
	 * @param name
	 * @param maxDamage
	 * @param durability
	 */
	public Weapon(String name, int maxDamage, int durability) {
		this.name = name;
		this.maxDamage = maxDamage;
		this.durability = durability;
	}


	/**
	 * @return getName
	 */
	// getters
	public String getName() {return this.name;}

	/**
	 * @return durability
	 */
	public int durability() {return this.durability;}
	public TYPE getType() {return this.type;}
	public int maxDamage() {
		if (durability <= 0) {
			return 0;
		} else {
			return maxDamage;
		}
	}
	// setters
	public void setName(String name) {this.name = name;}
	public void setMaxDamage(int maxDamage) {this.maxDamage = maxDamage;}
	public void setType(TYPE type) {this.type = type;}
	public void setDurability(int durability) {
		if (durability <= 0) {
			this.durability = 0;
			this.maxDamage = 0;
		} else {
		this.durability = durability;
		}
	}

	/**
	 * @return Get Damage
	 */
	// get attack damage for weapon
	public int getDamage() {
		Random rand = new Random();
		int attack = 0;
		// protected with try/catch to prevent 0 strength throwing error
		// and to prevent code spagettification 
		try {
			attack = rand.nextInt(maxDamage);
		} catch (IllegalArgumentException IVE) {
			attack = 0;
		}
		if (this.durability > 0) {
			setDurability(this.durability - 1);
			return attack;
		} else {
			return 0;
		}
	}

	/**
	 * @return Get special damage
	 */
	abstract public int getSpecDamage();
	
	// to string
	public String toString() {
		return "Weapon: " + this.name + "  Type: " + this.type + "\n Damage: " 
				+ this.maxDamage + "  Durability: " + this.durability;
	}
	
}
