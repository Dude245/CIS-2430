package utils;

import java.util.Scanner;
import java.util.Random;
import utils.Die;

/**
 * <p>Helper class for simulating various dice-rolling scenarios.</p> 
 * 
 * @author Drew Downie 0786342
 */
public class DieRoller {
 
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
    private static int[] roll (Die die, int numOfDice) {
        int[] rolls = new int[numOfDice];
        for (int i = 0; i < numOfDice; i++) {
            die.roll();
            rolls[i] = die.getFaceValue(); /* Shift by 1 to adjust for the range */
            System.out.printf("\tLOG (DieRoller): Roll %d = %d\n", i+1, rolls[i]);                        
        }
        return rolls;
    }
    
    /**
     * <p>Perform a standard roll according to current parameters 
     * and summate the rolled values.</p>
     * 
     * @return Value of the summation of all the rolls
     */
    public static int rollNormal (Die die, int numOfDice) {        
        int total = 0;
        int[] rolls;
        rolls = roll(die, numOfDice);
        for (int i = 0; i < rolls.length; i++) {                        
            total = total + rolls[i];            
        }
        return total;
    }
     
    /**
     * <p>Generate a value for use in an ability score using the Standard
     * approach, as stated in the Pathfinder Core Rulebook.</p>
     * @return Value of the rolled ability score
     */
    public static int generateAbilityScoreStandard () {   
        Die die = new Die(6);
        int rolls[] = roll(die, 4);
        int total = 0, lowestNum = 10000000;
        
        //find the lowest num, and subtract it from the total of all the dice rolled
        for(int i = 0; i < rolls.length; i++){
            if(rolls[i] < lowestNum){
                lowestNum = rolls[i];
            }
            total += rolls[i];
        }
        total -= lowestNum;
        
                        
        return total;
    }
}