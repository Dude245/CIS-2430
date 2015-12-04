package rpcharactermanager;
/**
 * <p>Character Manager that can be used in a role-playing game.</p>
 *
 * @author Nreymer/0797359
 */
import diceroller.DiceRoller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class RPCharacterManager {

    public static ArrayList<RPCharacter> characterList = new ArrayList<>();

    public static void main(String[] args) {
        DiceRoller test = new DiceRoller();
        Scanner in = new Scanner(System.in, "UTF-8");
        String choice;
        String fName;
        int iAge = 0;
        int currentC = -1;
        int stop = 0;
        int rollMe;
        String[] nameSearch;
        while (stop == 0) {
            RPCharacter newCharacter = new RPCharacter();
            System.out.println("");
            System.out.println("Please choose from one of the options");
            System.out.println("Create");
            System.out.println("Generate");
            System.out.println("Print");
            System.out.println("Exit \n");
            choice = in.nextLine();
            //Convert ipnut to lower case, compare with switch
            choice = choice.toLowerCase(Locale.ENGLISH);
            switch (choice) {
                case "create": {
                    System.out.println("Please Enter First name:");
                    fName = in.nextLine().trim();
                    fName = fName.replaceAll("!|/|-|#|$|%|^|&", "");    //Strip all the stuff I dont want away
                    if ("".equals(fName) | fName == null) { //Check if valid input
                        System.out.println("Sorry, you need to give me a name");
                        break;
                    }
                    newCharacter.setFirstName(choice);  //Add it to the ArrayList
                    System.out.println("Please Enter Last name:");
                    choice = in.nextLine().trim();
                    choice = choice.replaceAll("!|/|-|#|$|%|^|&", "");
                    if ("".equals(choice) | choice == null) {
                        System.out.println("Sorry, you need to give me a name");
                        break;
                    }
                    for (int i = 0; i < characterList.size(); i++) {    //Check Duplicates 
                            if (characterList.get(i).getLastName().equalsIgnoreCase(fName)&& characterList.get(i).getLastName().equalsIgnoreCase(choice)){
                                System.out.println("Please enter a uniqe name!");
                                break;
                            }
                        }
                    newCharacter.setLastName(choice);
                    System.out.println("Please Enter Age");
                    choice = in.nextLine().trim();      //Change string to int, add it to the Array List
                    try {
                        iAge = Integer.parseInt(choice);
                        newCharacter.setAge(iAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Lets try putting a number in, okay?");
                        break;
                    }

                    if ("".equals(choice) | choice == null | iAge >= 9000 | iAge < 5) { //Make sure its valid
                        System.out.println("Sorry, you need to give me a valid age!");
                        break;
                    }
                    characterList.add(newCharacter);    //Add the new element to the List
                    currentC++; //Counter for character
                    break;
                }
                case ("generate"): {
                    System.out.println("Do you want to change the last element? (Y/N)");
                    choice = in.nextLine().trim();
                    if (choice.equalsIgnoreCase("Y")) { //Change the last created element in the ArrayList
                        try {
                            rollMe = test.generateAbilityScoreStandard();
                            characterList.get(currentC).setCharisma(rollMe);
                        } catch (java.lang.IndexOutOfBoundsException e) {
                            System.out.println("Lets try creating that Character, okay?");
                            break;
                        }
                        //Generate all atributes, assign them to the values
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Charisma: " + rollMe);
                        characterList.get(currentC).setCharisma(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Intelligence: " + rollMe);
                        characterList.get(currentC).setIntelligence(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Wisdom: " + rollMe);
                        characterList.get(currentC).setWisdom(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Dexterity: " + rollMe);
                        characterList.get(currentC).setDexterity(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Strength: " + rollMe);
                        characterList.get(currentC).setStrength(rollMe);
                        break;
                    } else {
                        System.out.println("Which entry would you like to edit? (First,Last)");
                        choice = in.nextLine().trim();
                        nameSearch = choice.split(",");
                        for (int i = 0; i < characterList.size(); i++) {
                            if (characterList.get(i).getFirstName().equalsIgnoreCase(nameSearch[0]) && characterList.get(i).getLastName().equalsIgnoreCase(nameSearch[1])) {
                                currentC = i;
                                iAge = 1;
                            }
                        }
                        if (iAge != 1) {    //Cheater method without using new variables to return a failed search
                            System.out.println("Not found");
                            break;
                        }
                        try {
                            rollMe = test.generateAbilityScoreStandard();
                            characterList.get(currentC).setCharisma(rollMe);
                        } catch (java.lang.IndexOutOfBoundsException e) { //Catch exception for NULL list
                            System.out.println("Lets try creating that Character first, okay?");
                            break;
                        }
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Charisma: " + rollMe);
                        characterList.get(currentC).setCharisma(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Intelligence: " + rollMe);
                        characterList.get(currentC).setIntelligence(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Wisdom: " + rollMe);
                        characterList.get(currentC).setWisdom(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Dexterity: " + rollMe);
                        characterList.get(currentC).setDexterity(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Strength: " + rollMe);
                        characterList.get(currentC).setStrength(rollMe);
                        break;
                    }
                }
                    case ("print"): {
                    System.out.println();
                    for (Iterator<RPCharacter> it = characterList.iterator(); it.hasNext();) {
                        RPCharacter book = it.next();
                        System.out.println(book);
                    }
                    break;
                }
                case ("exit"): {
                    System.out.println("Exit"); //Exit
                    stop = 1;
                }
                default:
                {
                    System.out.println("Try again ");   //Anything thats not recognized
                }
            }
        }
    }
}
