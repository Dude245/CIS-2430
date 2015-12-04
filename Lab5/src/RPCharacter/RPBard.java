
package RPCharacter;

import utils.Die;
import utils.DieRoller;

/**
 * <p>Representation of a bard.</p>
 *
 * @author Nathan Reymer 0797359
 */
public class RPBard extends RPCharacter{
    /**
     * <p>Character's hit die.</p>
     */
    final private Die hitDie = new Die(8);
    
     public RPBard(String firstName, String lastName, int age, String characterClass){
        super(firstName, lastName, age, characterClass);
        this.setHitDie(new Die(8));
    }
     public RPBard(String characterClass){
        super(characterClass);
        this.setHitDie(new Die(8));
    }
     
     
    public String castSpell(RPCharacter target){
        return this.getFirstName() + " casts a spell on: " + target.getFirstName();
    }
    
     public String attack(RPCharacter target){
        int attackRoll = new Die(20).getFaceValue() + (this.getStrength() / 4);
        int dmgAmount;
        
        if(attackRoll >= target.getArmorClass()){
            dmgAmount = DieRoller.rollNormal(this.getHitDie(), this.getLevel());
            dmgAmount += this.getStrength()/8;
            return this.getFirstName() + "'s Attack hit " + target.getFirstName() + " for: " + dmgAmount + "damage!";
        }else{
            return this.getFirstName() + "'s Attack missed " + target.getFirstName() + "!";
        }
        
    }
    
    public String useSkill(RPCharacter target){
        return this.getFirstName() + " used a skill on on: " + target.getFirstName();
    }
    
    @Override
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
