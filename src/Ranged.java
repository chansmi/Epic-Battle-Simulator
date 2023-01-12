import java.util.Random;

/**
 * Ranged weapon class
 */
public class Ranged extends Weapon{

	/**
	 * Ranged weapon with name, max Damage, and durability
	 * @param name
	 * @param maxDamage
	 * @param durability
	 */
	// constructors
	public Ranged(String name, int maxDamage, int durability) {
		super(name, maxDamage, durability);
		this.setType(TYPE.Ranged);
	}
	
	public int getSpecDamage() {
		Random rand = new Random();
		int attack = 0;
		// protected with try/catch to prevent 0 strength throwing error
		// and to prevent code spagettification 
		try {
			attack = rand.nextInt(2 * maxDamage());
		} catch (IllegalArgumentException IVE) {
			attack = 0;
		}
		if (this.durability() > 0) {
			setDurability(this.durability() - 1);
			return attack;
		} else {
			return 0;
		}
		
	}
}
