/* The creative element is a IntelliJ GUI which
 allows you to enter characters and pit them against one another */

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Locale;

/**
 * the GUIIIIIIIII
 */
public class Colosseum extends JFrame {
    private JPanel battlePanel;
    private JPanel topPanel;
    private JButton fightButton;
    private JPanel heroPanel;
    private JPanel villianPanel;
    private JTextArea heroTextArea;
    private JTextField heroHitPoints;
    private JTextArea villianTextArea;
    private JTextField heroName;
    private JTextPane manaTextPane1;
    private JTextPane strengthTextPane;
    private JTextPane hitPointsTextPane1;
    private JTextPane nameTextPane;
    private JTextPane manaTextPane;
    private JTextPane strengthTextPane1;
    private JTextPane hitPointsTextPane;
    private JTextPane nameTextPane1;
    private JTextField heroStrength;
    private JTextField heroMana;
    private JTextField villianName;
    private JTextField villianHitPoints;
    private JTextField villianMana;
    private JTextField villianStrength;
    private JTextPane clickFightToDiscoverTextPane;
    private PrintStream standardOut;

    // ADD a MANA Section

    public Colosseum() {
        // getting battle arena to run
        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Sets up the inputs for execution
                String hName = heroName.getText();
                // hero hitPoints
                String hHitPointsString = heroHitPoints.getText();
                int hHitPoints = 0;
                if (hHitPointsString.matches("[0-9]+"))               //Perform validation before parsing string
                    hHitPoints = Integer.parseInt(hHitPointsString);
                // hero Strength
                String hStrengthString = heroStrength.getText();
                int hStrength = 0;
                if (hStrengthString.matches("[0-9]+"))
                    hStrength = Integer.parseInt(hStrengthString);
                // hero mana
                String hManaString = heroMana.getText();
                int hMana = 0;
                if (hManaString.matches("[0-9]+"))
                    hStrength = Integer.parseInt(hManaString);
                // Villian name
                String vName = villianName.getText();
                // villian hitPoints
                String vHitPointsString = villianHitPoints.getText();
                int vHitPoints = 0;
                if (vHitPointsString.matches("[0-9]+"))
                    vHitPoints = Integer.parseInt(vHitPointsString);
                // villian strength
                String vStrengthString = villianStrength.getText();
                int vStrength = 0;
                if (vStrengthString.matches("[0-9]+"))
                    vStrength = Integer.parseInt(vStrengthString);
                // villian mana
                String vManaString = villianMana.getText();
                int vMana = 0;
                if (vManaString.matches("[0-9]+"))
                    vStrength = Integer.parseInt(vManaString);


                // Edit and then instead of calling Battle Arena, call fight
                Character hero = new Hero(hName, hHitPoints, hStrength, hMana);
                Character BadGuy = new BadGuy(vName, vHitPoints, vStrength, vMana);
                Character winner = BattleArenaGui.fight(hero, BadGuy);
                Character finalWinner = winner;
                JOptionPane.showMessageDialog(battlePanel, finalWinner);
            }
        });
    }
//end constructor

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colosseum");
        frame.setContentPane(new Colosseum().battlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}



// could implement the weapon class
    /* hero weapon
                String hWeaponString = villianHitPoints.getText();
                Weapon.TYPE hWeapon = Weapon.TYPE.Melee;
                hWeapon = Weapon.TYPE.*/
//Weapon hWeapon = heroWeapon.getText();