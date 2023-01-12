/**
 * Melee weapon class
 */
public class Melee extends Weapon {

	/**
	 * melee weapon
	 * @param name
	 * @param maxDamage
	 * @param durability
	 */
	// constructors
	public Melee(String name, int maxDamage, int durability) {
		super(name, maxDamage, durability);
		this.setType(TYPE.Melee);
	}

	/**
	 * @return spec damage
	 */
	public int getSpecDamage() {
		int attack = this.maxDamage();
		if (this.durability() >= attack) {
			setDurability(this.durability() - attack);
			return attack;
		} else {
			return this.durability();
		}
	}
}
