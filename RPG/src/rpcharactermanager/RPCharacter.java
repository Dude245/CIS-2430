package rpcharactermanager;

/**
 * <p>Representation of a character that can be used in a role-playing game.</p>
 *
 * @author (fill in your Moodle/UoG username)
 */
public class RPCharacter {

    /**
     * <p>First name of the character.</p>
     */
    private String firstName;
    /**
     * <p>Last name of the character.</p>
     */
    private String lastName;
    /**
     * <p>Age of the character (must be at least 5 years old).</p>
     */
    private int age;
    // Credits - The following ability descriptions were taken straight from the Pathfinder Core Rulebook
    /**
     * <p>Character's muscle and physical power.</p>
     */
    private int strength;
    /**
     * <p>Character's agility, reflexes and balance.</p>
     */
    private int dexterity;
    /**
     * Characters constitution
     */
    private int charisma;
    /**
     * Character's influence with people
     */
    private int intelligence;
    /**
     * Characters intelligence
     */
    private int wisdom;

    /**
     * How smrt they is
     */
    /*
     
     
     /**
     * <p>Sets the First name for the character.</p>
     *
     * @param str Value for the character's Name 
     */
    public void setFirstName(String str) {
        this.firstName = str;
    }

    /**
     * <p>Sets the Last name for the character.</p>
     *
     * @param str Value for the character's Name
     */
    public void setLastName(String str) {
        this.lastName = str;
    }

    /**
     * <p>Sets the Age the character.</p>
     *
     * @param str Value for the character's Age
     */
    public void setAge(int str) {
        this.age = str;
    }

    /**
     * <p>Sets the Strength for the character.</p>
     *
     * @param str Value for the character's Strength
     */
    public void setStrength(int str) {
        this.strength = str;
    }

    /**
     * <p>Sets the Charisma for the character.</p>
     *
     * @param str Value for the character's Charisma
     */
    public void setCharisma(int cha) {
        this.charisma = cha;
    }

    /**
     * <p>Sets the INtelgence for the character.</p>
     *
     * @param str Value for the character's Intelegence
     */
    public void setIntelligence(int inte) {
        this.intelligence = inte;
    }

    /**
     * <p>Sets the Wisdom for the character.</p>
     *
     * @param str Value for the character's Wisdom
     */
    public void setWisdom(int wis) {
        this.wisdom = wis;
    }

    /**
     * <p>Sets the Dexterity ability score for the character.</p>
     *
     */
    public void setDexterity(int dex) {
        this.dexterity = dex;
    }

    /**
     * <p>Retrieves the First name of the character.</p>
     *
     * @return First name of the character
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * <p>Retrieves the last name of the character.</p>
     *
     * @return Last name of the character
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * <p>Retrieves the Age of the character.</p>
     *
     * @return Age of the character
     */
    public int getAge() {
        return this.age;
    }
    @Override
    public String toString() {
        return "Character: \n" + firstName + " " + lastName + "\n" + "Age: " + age + " \n"
                + "Charisma: " + charisma + " \n"+"Dexterity "+dexterity+ "\n"+"Intelligence: "+intelligence+"\n"
                +"Wisdom: "+wisdom+"\n"+"Strength: "+strength+"\n"+"\n";
        
    }
}
