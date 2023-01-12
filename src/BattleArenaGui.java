/**
Special GUI file specific to the 1v1 fight with random generators
 */
;
import java.util.Random;
import java.util.Scanner;

public class BattleArenaGui {
    static private Scanner scan = new Scanner(System.in);

    /**
     * fight class, battle between two warriors
     * @param c1
     * @param c2
     * @return
     */
    public static Character fight(Character c1, Character c2) {
        while (c1.isAlive() && c2.isAlive()) {
            // choose attack type
            System.out.print("\nChoose attack type: \n"
                    + "    attack"
                    + "    use weapon"
                    + "    special"
                    + "\n> ");

            // get damage
            /*
            WHAT WE WILL NEED
            -Random Number 0-2
            -inside the while loop, that would be the if, else
*/
            int damage = -1;
            Random rand = new Random();
            int n = rand.nextInt(2);
            n += 1;

            while (damage == -1) {
                if (n == 1) {
                    damage = c1.attack();
                } else if (n == 2) {
                    damage = c1.attackWithWeapon();
                } else if (n == 3) {
                    damage = ((Hero) c1).specAttackWithWeapon();
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
}}