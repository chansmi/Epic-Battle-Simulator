
//Game driver
//Notice it's the only class declared as public.

// Jasmine and Chandler Collaborated on this!

import java.util.LinkedList;

/**
 * Battle Arena Driver class
 */
public class BattleArenaDriver
{
	public static void main(String [] args)
	{
		// set characters
		Hero hero = new Hero("Sparhawk", 40, 100);
		Hero hero2 = new Hero("Cohen", 100, 100);
		BadGuy badguy = new BadGuy("Gwerg", 100, 100);
		BadGuy badguy2 = new BadGuy("Gothmog", 300, 50);
		LinkedList<Hero> heroList = new LinkedList<Hero>();
		heroList.add(hero);
		heroList.add(hero2);
		heroList.add(new Hero());
		LinkedList<BadGuy> badGuys = new LinkedList<BadGuy>();
		badGuys.add(badguy);
		badGuys.add(badguy2);

		// get battle arena
		BattleArena b1 = new BattleArena(heroList, badGuys);
		// set weapons and armor
		Weapon mace = new Melee("Mace", 5, 20);
		Weapon sword = new Melee("Sword", 10, 10);
		hero.setWeapon(mace);
		badguy.setWeapon(sword);

		// print stats and fight
		b1.battle();

		//hero.print(); // dynamic
		//System.out.println(hero); 
		//System.out.println(hero.getWeapon());
		// System.out.print(hero.getArmor());
		//System.out.println(hero);
	}
}



/* DONE Add a Weapon class with a name, maxDamage, and durability*/
/* DONE Add a getDamage() to Weapon that returns an attack value from
 * 1 - maxDamage and subtracts 1 from durability*/
/* DONE Deduct 1 from durability each time the weapon is used and
 * return 0 for damage if the weapon has no durability*/
/* DONE Add the ability for the character to have a weapon and
 * use it within the character getDamage() method */
/* DONE Add a toString override to weapon and print all details
 * in the driver */
/* DONE Add one creative element all your own FROM JNO: armor class - implemented GUI */


