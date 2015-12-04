/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCharacter;
import utils.Die;

/**
 * <p>Representation of a wizard.</p>
 *
 * @author Nathan Reymer 0797359
 */
public class RPWizard extends RPCharacter{
    /**
     * <p>Character's hit die.</p>
     */
    final private Die hitDie = new Die(6);
    
    public RPWizard(String firstName, String lastName, int age, String characterClass){
        super(firstName, lastName, age, characterClass);
        this.setHitDie(new Die(6));
    }
    public RPWizard(String characterClass){
        super(characterClass);
        this.setHitDie(new Die(6));
    }
    
    
    
    public String castSpell(RPCharacter target){
        return this.getFirstName() + " casts a spell on: " + target.getFirstName();
    }
    
    public String toString(){
        return super.toString();
    }
    
     /**
     * <p>Prints a string that tells what direction a character walked in.</p>
     *
     */
    public String walk (int direction){
        return super.walk(direction);
    }
    
    /**
     * <p>Prints a string that tells what direction a character ran in.</p>
     *
     */
    public String run (int direction){
         return super.run(direction);
    }
}
