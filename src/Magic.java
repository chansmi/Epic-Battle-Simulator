/**
 * Public class magic which extends weapon for a magical weapon
 */
/*
Magic class which implemets magic and mana requirements
 */
public class Magic extends Weapon {
	private int manaCost;

	/**
	 * Magic constructor with name, maxDamage, and durability
	 * @param name
	 * @param maxDamage
	 * @param durability
	 */
	// constructors
	public Magic(String name, int maxDamage, int durability) {
		super(name, maxDamage, durability);
		this.setType(TYPE.Magic);
	}

	/**Magic constructor with name, maxDamage, durability, and mana cost
	 * @param name
	 * @param maxDamage
	 * @param durability
	 * @param manaCost
	 */
	public Magic(String name, int maxDamage, int durability, int manaCost) {
		super(name, maxDamage, durability);
		this.manaCost = manaCost;
		this.setType(TYPE.Magic);
	}

	/**
	 * @return mana cost
	 */
	public int getManaCost() {
		return this.manaCost;
	}

	/**
	 * @return spec damage
	 */
	public int getSpecDamage() {
		int attack = 2 * this.maxDamage();
		if (this.durability() >= 1) {
			setDurability(this.durability() - 1);
			return attack;
		} else {
			return 0;
		}
	}
}
