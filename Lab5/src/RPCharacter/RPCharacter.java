package RPCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import utils.Die;

/**
 * @author Nathan Reymer 0797359
 */
public class RPCharacter {
    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */

    /**
     * <p>
     * First name of the character.</p>
     */
    private String firstName;
    /**
     * <p>
     * Last name of the character.</p>
     */
    private String lastName;
    /**
     * <p>
     * Age of the character (must be at least 5 years old).</p>
     */
    private int age;
    /**
     * constants for editing the hash map of character ability scores
     */
    final String strength = "STR";
    final String dexterity = "Dex";
    final String constitution = "CON";
    final String intelligence = "INT";
    final String wisdom = "WIS";
    final String charisma = "CHA";

    /**
     * holds the 6 character attributes
     */
    HashMap<String, String> attributes = new HashMap();
    /**
     * <p>
     * Character's level.</p>
     */
    private int level;
    /**
     * <p>
     * Character's speed.</p>
     */
    private float speed;
    /**
     * <p>
     * Character's armor class.</p>
     */
    private int armorClass;
    /**
     * <p>
     * Character's class.</p>
     */
    final private String characterClass;
    /**
     * <p>
     * Character's hit die.</p>
     */
    private Die hitDie = new Die();

    // TODO ...etc...Fill in the rest...
    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    public RPCharacter(String firstName, String lastName, int age, String characterClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.characterClass = characterClass;
    }

    public RPCharacter(String characterClass) {
        this.characterClass = characterClass;
    }

    // TODO
    /*
     * --------
     * MUTATORS
     * --------
     */
    /**
     * <p>
     * Sets the first name for the character.</p>
     *
     * @param fName Value for the character's Strength
     */
    public void setFirstName(String fName) {
        if (fName.matches("^[a-zA-Z'-]+$")) {
            this.firstName = fName;
           }
    }

    /**
     * <p>
     * Sets the last name for the character.</p>
     *
     * @param lName Value for the character's Strength
     */
    public void setLastName(String lName) {
        if (lName.matches("^[a-zA-Z'-]+$")) {
            this.lastName = lName;

        }}

    /**
     * <p>
     * Sets the age for the character.</p>
     *
     * @param age Value for the character's Strength
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * <p>
     * Sets the Strength ability score for the character.</p>
     *
     * @param str Value for the character's Strength
     */
    public void setStrength(int str) {
        this.attributes.put(strength, "" + str);
    }

    /**
     * <p>
     * Sets the Dexterity ability score for the character.</p>
     *
     * @param DEX Value for the character
     */
    public void setDexterity(int dex) {
        this.attributes.put(dexterity, "" + dex);
            armorClass = 10 + (dex / 4);;
    }

    /**
     * <p>
     * Sets the constitution ability score for the character.</p>
     *
     * @param CONS Value for the charactery
     */
    public void setConstitution(int cons) {
        this.attributes.put(constitution, "" + cons);
    }

    /**
     * <p>
     * Sets the intelligence ability score for the character.</p>
     *
     * @param INTEL Value for the characterd
     */
    public void setIntelligence(int intel) {
        this.attributes.put(intelligence, "" + intel);
    }

    /**
     * <p>
     * Sets the intelligence ability score for the character.</p>
     *
     * @param WIS Value for the character
     */
    public void setWisdom(int wis) {
        this.attributes.put(wisdom, "" + wis);
    }

    /**
     * <p>
     * Sets the intelligence ability score for the character.</p>
     *
     * @param CHARI Value for the character
     */
    public void setCharisma(int chari) {
        this.attributes.put(charisma, "" + chari);
    }

    /**
     * <p>
     * Sets the speed ability score for the character.</p>
     *
     * @param SPD Value for the character's speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * <p>
     * Sets the level for the character.</p>
     *
     * @param LVL Value for the character
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * <p>
     * Sets the hit die for the character.</p>
     *
     * @param hit die Value for the character
     */
    public void setHitDie(Die die) {
        this.hitDie = die;
    }

    /*
     * ---------
     * ACCESSORS
     * ---------
     */
    /**
     * <p>
     * Retrieves the first name of the character.</p>
     *
     * @return First name of the character
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * <p>
     * Retrieves the last name of the character.</p>
     *
     * @return Last name of the character
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * <p>
     * Retrieves the age of the character.</p>
     *
     * @return age of the character
     */
    public int getAge() {
        return this.age;
    }

    /**
     * <p>
     * Retrieves the strength of the character.</p>
     *
     * @return strength of the character
     */
    public int getStrength() {
        try {
            return Integer.parseInt(this.attributes.get(strength));
        } catch (NumberFormatException e) {
            System.out.println("error in getStrenth");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the dexterity of the character.</p>
     *
     * @return dexterity of the character
     */
    public int getDexterity() {
        try {
            return Integer.parseInt(this.attributes.get(dexterity));
        } catch (NumberFormatException e) {
            System.out.println("error in getDexterity");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the constitution of the character.</p>
     *
     * @return constitution of the character
     */
    public int getConstitution() {
        try {
            return Integer.parseInt(this.attributes.get(constitution));
        } catch (NumberFormatException e) {
            System.out.println("error in getConsitution");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the intelligence of the character.</p>
     *
     * @return intelligence of the character
     */
    public int getIntelligence() {
        try {
            return Integer.parseInt(this.attributes.get(intelligence));
        } catch (NumberFormatException e) {
            System.out.println("error in getIntelligence");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the wisdom of the character.</p>
     *
     * @return wisdom of the character
     */
    public int getWisdom() {
        try {
            return Integer.parseInt(this.attributes.get(wisdom));
        } catch (NumberFormatException e) {
            System.out.println("error in getWisdom");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the charisma of the character.</p>
     *
     * @return charisma of the character
     */
    public int getCharisma() {
        try {
            return Integer.parseInt(this.attributes.get(charisma));
        } catch (NumberFormatException e) {
            System.out.println("error in getCharisma");
            return 0;
        }
    }

    /**
     * <p>
     * Retrieves the level of the character.</p>
     *
     * @return level of the character
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * <p>
     * Retrieves the speed of the character.</p>
     *
     * @return speed of the character
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * <p>
     * Retrieves the armor class of the character.</p>
     *
     * @return armor class of the character
     */
    public int getArmorClass() {
        return this.armorClass;
    }

    /**
     * <p>
     * Retrieves the character class of the character.</p>
     *
     * @return character class of the character
     */
    public String getCharacterClass() {
        return this.characterClass;
    }

    /**
     * <p>
     * Retrieves the hitDie of the character.</p>
     *
     * @return hitDie of the character
     */
    public Die getHitDie() {
        return this.hitDie;
    }

    /**
     * <p>
     * Returns a string that contains all info about the character.</p>
     *
     * @return string info about the character
     */
    public String toString() {
        //print name and age
        String value = "Name: ";
        value += this.firstName + " " + this.lastName + "\n";
        value += "Age: " + this.age + "\n";

        //attributes
        value += "Strenth: " + this.attributes.get(strength) + "\n";
        value += "Dexterity: " + this.attributes.get(dexterity) + "\n";
        value += "Constitution: " + this.attributes.get(constitution) + "\n";
        value += "Intelligence: " + this.attributes.get(intelligence) + "\n";
        value += "Wisdom: " + this.attributes.get(wisdom) + "\n";
        value += "Charisma: " + this.attributes.get(charisma) + "\n";
        value += "Speed: " + this.speed + "\n";
        value += "Level: " + this.level + "\n";
        value += "ArmorClass: " + this.armorClass + "\n";
        value += "CharacterClass: " + this.characterClass + "\n";
        value += "HitDie: " + this.hitDie + "\n";
        return value;
    }

    /**
     * <p>
     * Returns a boolean representing whether or not two objects are equal.</p>
     *
     * @param o
     * @return boolean if two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        //this needs to be done,
        return false;
    }

    /**
     * <p>
     * Prints a string that tells what direction a character walked in.</p>
     *
     * @param direction
     * @return
     */
    public String walk(int direction) {
        if (direction == 1) {
            return "Character has walked " + this.speed + " feet North";
        } else if (direction == 2) {
            return "Character has walked " + this.speed + " feet East";
        } else if (direction == 3) {
            return "Character has walked " + this.speed + " feet South";
        } else if (direction == 4) {
            return "Character has walked " + this.speed + " feet West";
        } else {
            return "Invalid direction in function 'walk'";
        }
    }

    /**
     * <p>
     * Prints a string that tells what direction a character ran in.</p>
     *
     * @param direction
     * @return
     */
    public String run(int direction) {
        if (direction == 1) {
            return "Character has ran " + this.speed * 3 + " feet North";
        } else if (direction == 2) {
            return "Character has ran " + this.speed * 3 + " feet East";
        } else if (direction == 3) {
            return "Character has ran " + this.speed * 3 + " feet South";
        } else if (direction == 4) {
            return "Character has ran " + this.speed * 3 + " feet West";
        } else {
            return "Invalid direction in function 'run'";
        }
    }

    /**
     * takes a hash map, and writes them to a character object
     *
     * @param hash
     * @return
     */
    public static RPCharacter convertHashMapToCharacter(HashMap<String, String> hash) {
        RPCharacter newCharacter;
        Iterator it = hash.entrySet().iterator();
 switch ((String) hash.get("Class")) {
                case "WIZARD":
                    //class is wizzard
                    newCharacter = new RPWizard("WIZARD");
                    break;
                case "FIGHTER":
                    //class is fighter
                    newCharacter = new RPFighter("FIGHTER");
                    break;
                case "BARD":
                    //class is bard
                    newCharacter = new RPBard("BARD");
                    break;
                default:
                    newCharacter = new RPCharacter("convert hash map to character function error, class unable to be set!");
            }
        while (it.hasNext()) {

           
            Map.Entry hashEntry = (Map.Entry) it.next();

            switch (((String) hashEntry.getKey()).toLowerCase()) {
                case "firstname":
                    //key is 'firstname'
                    newCharacter.setFirstName((String) hashEntry.getValue());
                    break;
                case "lastname":
                    //key is 'lastname'
                    newCharacter.setLastName((String) hashEntry.getValue());
                    break;
                case "age":
                    //key is 'age'
              
                        newCharacter.setAge(Integer.parseInt((String) hashEntry.getValue()));
                    break;
                case "str":
                    //key is 'strength'
                    
                        newCharacter.setStrength(Integer.parseInt((String) hashEntry.getValue()));
                  
                    break;
                case "dex":
                    //key is 'dexterity'
                    
                        newCharacter.setDexterity(Integer.parseInt((String) hashEntry.getValue()));
                  
                    break;
                case "con":
                    //key is 'constitution'
                   
                        newCharacter.setConstitution(Integer.parseInt((String) hashEntry.getValue()));
                   
                    break;
                case "int":
                    //key is 'intelligence'
                    
                        newCharacter.setIntelligence(Integer.parseInt((String) hashEntry.getValue()));
                  
                    break;
                case "wis":
                    //key is 'wisdom'
                        newCharacter.setWisdom(Integer.parseInt((String) hashEntry.getValue()));
                
                    break;
                case "cha":
                    //key is 'charisma'
                    
                        newCharacter.setCharisma(Integer.parseInt((String) hashEntry.getValue()));
                    
                    break;
                case "level":
                    //key is 'level'
                    
                        newCharacter.setLevel(Integer.parseInt((String) hashEntry.getValue()));
                    
                    break;
                case "speed":
                    //key is 'speed'
                    
                        newCharacter.setSpeed(Float.parseFloat((String) hashEntry.getValue()));
                    
                    break;
            }

        }
        return newCharacter;
    }

    /**
     * takes a list of hash maps, and writes them to a list of character objects
     *
     * @param hashList
     * @return
     */
    public static ArrayList<RPCharacter> convertHashMapListToCharacterList(ArrayList<HashMap<String, String>> hashList) {
        Iterator<HashMap<String, String>> it = hashList.iterator();
        ArrayList<RPCharacter> characterList = new ArrayList();
        RPCharacter newChar;

        while (it.hasNext()) {
            newChar = convertHashMapToCharacter(it.next());
            characterList.add(newChar);
        }

        return characterList;
    }

    /**
     * takes a characters info and stores into in a hash map
     *
     * @param character
     * @return
     */
    public static HashMap<String, String> convertCharacterToHashMap(RPCharacter character) {
        HashMap<String, String> hash = new HashMap<String, String>();

        hash.put("Class", character.getCharacterClass());
        hash.put("FirstName", character.getFirstName());
        hash.put("LastName", character.getLastName());
        hash.put("age", character.getAge() + "");
        hash.put("STR", character.getStrength() + "");
        hash.put("DEX", character.getDexterity() + "");
        hash.put("CON", character.getConstitution() + "");
        hash.put("INT", character.getIntelligence() + "");
        hash.put("WIS", character.getWisdom() + "");
        hash.put("CHA", character.getCharisma() + "");
        hash.put("level", character.getLevel() + "");
        hash.put("speed", character.getSpeed() + "");

        return hash;
    }

    /**
     * takes a list of characters info and stores into in a list of hash maps
     *
     * @param characters
     * @return
     */
    public static ArrayList<HashMap<String, String>> convertCharacterListToHashMapList(ArrayList<RPCharacter> characterList) {
        Iterator<RPCharacter> it = characterList.iterator();
        ArrayList<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> currentHash;

        while (it.hasNext()) {
            currentHash = convertCharacterToHashMap(it.next());
            hashList.add(currentHash);
        }

        return hashList;
    }
}
