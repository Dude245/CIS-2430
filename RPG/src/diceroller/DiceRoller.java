package diceroller;

import java.util.Scanner;
import java.util.Random;

/**
 * <p>Helper class for simulating various dice-rolling scenarios.</p>
 *
 * @author nreymer
 */
public class DiceRoller {

    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
    /**
     * <p>Number of sides of each die.</p>
     */
    private int d;
    /**
     * <p>Number of dice to be rolled.</p>
     */
    private int n;

    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    /**
     * <p>Default constructor creates an object that represents one six-sided
     * die being rolled once.</p>
     */
    public DiceRoller() {
        this.d = 6;
        this.n = 1;
    }

    /**
     * <p>Standard constructor creates an object according to the specified
     * number of sides of each die and the total number of dice.</p>
     *
     * @param numSides Number of sides of each die
     * @param numDice Count of the total number of dice to be used
     */
    public DiceRoller(int numSides, int numDice) {
        // A die can not have 0 or negative sides
        if (numSides <= 0) {
            this.d = 6;
        } else {
            this.d = numSides;
        }

        // One can not roll 0 or a negative number of dice
        if (numDice <= 0) {
            this.n = 1;
        } else {
            this.n = numDice;
        }
    }

    /*
     * --------
     * MUTATORS
     * --------
     */
    /**
     * <p>Sets the number of sides of each die for future rolls.</p>
     *
     * @return <code>true</code> if the new value was
     * assigned; <code>false</code> if the assignment failed
     */
    public boolean setNumberOfSides(int numSides) {
        // A die can not have 0 or negative sides
        if (numSides <= 0) {
            return false;
        } else {
            this.d = numSides;
            return true;
        }
    }

    /**
     * <p>Sets the total number of dice that will be used for future rolls.</p>
     *
     * @param numDice Count of the total dice to be used
     * @return <code>true</code> if the new value was
     * assigned; <code>false</code> if the assignment failed
     */
    public boolean setNumberOfDice(int numDice) {
        // One can not roll 0 or a negative number of dice
        if (numDice <= 0) {
            return false;
        } else {
            this.n = numDice;
            return true;
        }
    }

    /*
     * ---------
     * ACCESSORS
     * ---------
     */
    /**
     * <p>Retrieves the current number of sides of each die.</p>
     *
     * @return Number of sides of each die
     */
    public int getNumberOfSides() {
        return this.n;
    }

    /**
     * <p>Retrieves the current number of dice being used.</p>
     *
     * @return Count of the total number of dice to be used
     */
    public int getNumberOfDice() {
        return this.n;
    }

    /*
     * ------------------------
     * DICE-ROLLING OPERATIONS
     * ------------------------
     */
    /**
     * <p>Perform a roll according to the current values for the number of dice
     * and the number of sides of each die.</p>
     *
     * @return Array of all the rolled values
     */
    private int[] roll() {
        int[] rolls = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            rolls[i] = 1 + new Random(System.nanoTime()).nextInt(this.d); /* Shift by 1 to adjust for the range */
            //System.out.printf("\tLOG (DiceRoller): Roll %d = %d\n", i+1, rolls[i]);                        
        }
        return rolls;
    }

    /**
     * <p>Perform a standard roll according to current parameters and summate
     * the rolled values.</p>
     *
     * @return Value of the summation of all the rolls
     */
    public int rollNormal() {
        int total = 0;
        int[] rolls = this.roll();
        for (int i = 0; i < rolls.length; i++) {
            total = total + rolls[i];
        }
        return total;
    }

    /**
     * <p>Generate a value for use in an ability score using the Standard
     * approach, as stated in the Pathfinder Core Rulebook.</p>
     *
     * @return Value of the rolled ability score
     */
    public int generateAbilityScoreStandard() {
        int total;
        int rolls[];
        rolls = new int[4];
        for (int x = 0; x <3; x++) {
            rolls[x] = rollNormal();
        }
        int smallest = 6;
        for (int i = 0; i < 3; i++) {
            if (rolls[i] < smallest) {
                smallest = rolls[i];
            }
        }
        total=rolls[0]+rolls[1]+rolls[2];
        // TODO

        return total;
    }
}