/*
Jasmine and Chandler
July 18th
Creative Battle Arena Lab
 */

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


/**
 Battle Arena class object
 */
public class BattleArena {
	static private Scanner scan = new Scanner(System.in);

	private LinkedList<Hero> heroList;
	private LinkedList<BadGuy> badGuyList;

	/**
	 * Battle arean constructor
	 * @param heroList
	 * @param badGuyList
	 */
	public BattleArena(LinkedList<Hero> heroList,
					   LinkedList<BadGuy> badGuyList) {
		this.heroList = heroList;
		this.badGuyList = badGuyList;
	}

	// for the GUI, the input here could be a list hero of one list, and a villian list of 1

	/**
	 * The great battle
	 * @return winner
	 */
	public void battle() {
		LinkedList<Weapon> weaponsRack = getWeaponsRack( heroList.size() );

		Character h = heroList.getFirst(); // we can add get random here
		Character b = badGuyList.getFirst();

		System.out.println(h.getName() + " enters the arena!");
		System.out.println(h + "\n");
		setBattleWeapon(weaponsRack, h);

		while (heroList.size() > 0 && badGuyList.size() > 0) {
			//setBattleWeapon(weaponsRack, h);

			System.out.println("\n\n" + b.getName() + " enters the arena!");
			System.out.println(b + "\n");

			System.out.println("--- " + h.getName() + " vs. "
					+ b.getName() + " ---");
			System.out.println("\nMatch Start!");

			Character v = fight(h, b);
			if (v instanceof Hero) {
				badGuyList.remove();
				try {
					b = badGuyList.getFirst();
				} catch (NoSuchElementException nsee) {}
			} else {
				heroList.remove();
				try {
					h = heroList.getFirst();
					System.out.println(h.getName() + " enters the arena!");
					System.out.println(h + "\n");
					setBattleWeapon(weaponsRack, h);
				} catch (NoSuchElementException nsee) {}
			}

		}

		if (heroList.size() > 0)
			System.out.println("\nThe heroes are victorious!");
		else
			System.out.println("\nThe forces of darkness have prevailed...");
	}

	/**
	 * Epic battle between two characters
	 * @return winner
	 */
	public static Character fight(Character c1, Character c2) {
		while(c1.isAlive() && c2.isAlive()){
			// choose attack type
			System.out.print("\nChoose attack type: \n"
					+ "    attack"
					+ "    use weapon"
					+ "    special"
					+ "\n> ");

			// get damage
			int damage = -1;
			while (damage == -1) {
				String input = scan.nextLine();

				if (input.equals("attack") ) {
					damage = c1.attack();
				} else if (input.equals("use weapon") ) {
					damage = c1.attackWithWeapon();
				} else if (input.equals("special") ) {
					damage = ( (Hero) c1).specAttackWithWeapon();
				} else {
					System.out.print("Unrecognized command. Try again. \n> ");
					damage = -1;
				}

			}


			System.out.println("\n" + c1.getName() + " hits " + c2.getName()
					+ " for " + damage + " damage");
			c2.takeDamage(damage);

			//Pause for 1 second to add some suspense
			//This is an example of a checked exception. It won't work without it...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//Don't do damage if 2nd combatant was killed
			if (c2.isAlive())
			{
				damage = c2.attack();
				System.out.println(c2.getName() + " hits "
						+ c1.getName() + " for " + damage);
				c1.takeDamage(damage);
			}
		}

		System.out.print("\nOur winner is : " );

		//Report the winner
		if (c1.isAlive()) {
			System.out.println(c1.getName() + "\n");
			return c1;
		} else
			System.out.println(c2.getName() + "\n");
		return c2;
	}

	private LinkedList<Weapon> getWeaponsRack(int size) {
		LinkedList<Weapon> weaponsRack = new LinkedList<Weapon>();
		String[] melee = {
				"Sword",
				"Mace",
				"Flail",
				"Axe",
				"Halberd",
				"Spear",
				"Club",
				"War horse"
		};
		String[] ranged = {
				"Short Bow",
				"Long Bow",
				"Cross Bow",
				"Blow gun",
				"Darts",
				"Sling",
				"Horse bow"
		};
		String[] magic = {
				"Wand",
				"Staff",
				"Bound dagger",
				"Potion bomb"
		};
		String[] descriptors = {
				"Cunning",
				"Bravery",
				"Fire",
				"the Wise",
				"the Demon Lord",
				"Heaven",
				"Death",
				"Strength",
				"Light",
				"Darkness",
				"the Blood God",
				"Judgement",
				"Engagement",
				"Serenity",
				"Doom",
				"Truth",
				"Lies"
		};

		Random r = new Random();
		for (int i = 0; i < size; i++) {
			if (r.nextInt(3) == 0) {
				int ml = r.nextInt(melee.length - 1);
				int d = r.nextInt(descriptors.length - 1);

				weaponsRack.add(
						new Melee(melee[ml] + " of " + descriptors[d],
								5 + r.nextInt(10),
								10 + r.nextInt(20) ));
			} else if (r.nextInt(3) == 0) {
				int rg = r.nextInt(ranged.length - 1);
				int d = r.nextInt(descriptors.length - 1);

				weaponsRack.add(
						new Ranged(ranged[rg] + " of " + descriptors[d],
								2 + r.nextInt(5),
								20 + r.nextInt(20) ));
			} else {
				int ma = r.nextInt(magic.length - 1);
				int d = r.nextInt(descriptors.length - 1);

				weaponsRack.add(
						new Magic(magic[ma] + " of " + descriptors[d],
								2 + 5 + r.nextInt(10),
								20 + r.nextInt(10) ,
								1 + r.nextInt(5)));
			}

		}

		return weaponsRack;
	}
	private static void print(LinkedList<Weapon> list) {
		int i = 1;
		for (Weapon w : list) {
			System.out.println(i + "\n" + w);
			i++;
		}
		System.out.println(i + "\n " + new Barehanded());
		System.out.println();
	}

	// get user input
	private int getWeaponChoice(int size) {
		int input = -1;
		while (input == -1) {
			String scanOutput = scan.nextLine();
			Scanner intReader = new Scanner(scanOutput);

			try {
				input = intReader.nextInt();

				if (input < 1 || input > size ) {
					System.out.println("Please enter a valid "
							+ "weapon number:");
					System.out.print("> ");
					input = -1;
				}

			} catch(InputMismatchException IME) {
				System.out.println("Please enter a valid weapon number:");
				System.out.print("> ");
			} catch (NoSuchElementException NSE) {
				System.out.println("You shouldn't be here:");
				System.out.print("> ");
			}

			intReader.close();

		}

		return input;

	}

	private void validateWeaponsChoice(int input,
									   LinkedList<Weapon> weaponsList,
									   Character h) {
		// convert user input to weapon choice
		int choice = input - 1;
		if (weaponsList.size() > 0 && choice != weaponsList.size() ) {
			h.setWeapon( weaponsList.get(choice) );
			weaponsList.remove(choice);
		}
	}

	private void setBattleWeapon(LinkedList<Weapon> weaponsRack,
								 Character h) {
		if (weaponsRack.size() > 0) {
			// print weapons
			System.out.println("Choose " + h.getName() + "'s weapon: \n");
			print(weaponsRack);
			System.out.print("> ");

			// get user input
			int input = getWeaponChoice(weaponsRack.size() + 1);
			validateWeaponsChoice(input, weaponsRack, h);
		}
	}

}
