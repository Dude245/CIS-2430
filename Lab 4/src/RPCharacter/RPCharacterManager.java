package RPCharacter;

import utils.Die;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import utils.FileIO;

/**
 * <p>
 * Character Manager that can be used in a role-playing game.</p>
 *
 * @author Nreymer/0797359
 */
public class RPCharacterManager {

    /**
     * Character Array List
     */
 
   public static ArrayList<RPCharacter> characterList = new ArrayList<>();
       static String CHARACTER_FILE_PATH = "C:\\Users\\Nathan\\Documents\\NetBeansProjects\\Lab 4\\src\\RPCharacter\\data\\rpdata.save";

    /**
     * Main PRogram
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Die test = new Die();
        FileIO FileIO = new FileIO();
        Scanner in = new Scanner(System.in, "UTF-8");
        String choice;
        String fName;
        int iAge = 0;
        int currentC = -1;
        int stop = 0;
        int rollMe;
        String[] nameSearch;

             ArrayList<HashMap<String, String>> characterHashList;
        characterHashList = FileIO.readDataFromFile(CHARACTER_FILE_PATH);
        characterList = RPCharacter.convertHashMapListToCharacterList(characterHashList);

        while(stop!=1)
        {          
                System.out.println("");
                System.out.println("Please choose from one of the options");
                System.out.println("Create");
                System.out.println("Edit");
                System.out.println("Print");
                System.out.println("Simulate");
                System.out.println("Search");
                System.out.println("Exit \n");
                choice = in.nextLine();
                //Convert ipnut to lower case, compare with switch
                choice = choice.toLowerCase(Locale.ENGLISH);
                switch (choice) {
                    case "c":
                        choice = "create";
                        break;
                    case "e":
                        choice = "edit";
                        break;
                    case "p":
                        choice = "print";
                        break;
                    case "s":
                        choice = "simulate";
                        break;
                    case "se":
                        choice = "search";
                        break;
                    case "q":
                        choice = "exit";
                        break;
                    default:
                        break;

                }
               
                switch (choice) {
                    case "create": {
                         RPCharacter newCharacter;
                        System.out.println("Please enter a Class: ");
                        choice = in.nextLine().trim();
                       if (choice.toLowerCase().equals("fighter") || choice.toLowerCase().equals("f")) {
                        newCharacter = new RPFighter("FIGHTER");

                    } else if (choice.toLowerCase().equals("wizard") || choice.toLowerCase().equals("w")) {
                        newCharacter = new RPWizard("WIZARD");

                    } else if (choice.toLowerCase().equals("bard") || choice.toLowerCase().equals("b")) {
                        newCharacter = new RPBard("BARD");
                    }
                       else
                    {
                        newCharacter = new RPCharacter("FIGHTER");
                    }
                        System.out.println("Please Enter First name:");
                        fName = in.nextLine().trim();
                        fName = fName.replaceAll("!|/|-|#|$|%|^|&", "");    //Strip all the stuff I dont want away
                        if ("".equals(fName)) { //Check if valid input
                            System.out.println("Sorry, you need to give me a name");
                            break;
                        }
                        newCharacter.setFirstName(fName);  //Add it to the ArrayList
                        System.out.println("Please Enter Last name:");
                        choice = in.nextLine().trim();
                        choice = choice.replaceAll("!|/|-|#|$|%|^|&", "");
                        if ("".equals(choice)) {
                            System.out.println("Sorry, you need to give me a name");
                            break;
                        }
                        for (int i = 0; i < characterList.size(); i++) {    //Check Duplicates
                            if (characterList.get(i).getLastName().equalsIgnoreCase(fName) && characterList.get(i).getLastName().equalsIgnoreCase(choice)) {
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
                        
                        if ("".equals(choice) | iAge >= 9000 | iAge < 5) { //Make sure its valid
                            System.out.println("Sorry, you need to give me a valid age!");
                            break;
                        }
                        System.out.println("Please Enter Level:");
                        choice = in.nextLine().trim();      //Change string to int, add it to the Array List
                        try {
                            iAge = Integer.parseInt(choice);
                            newCharacter.setLevel(iAge);
                        } catch (NumberFormatException e) {
                            System.out.println("Lets try putting a number in, okay?");
                            break;
                        }
                        System.out.println("Please Enter Speed:");
                        choice = in.nextLine().trim();      //Change string to int, add it to the Array List
                        try {
                            iAge = Integer.parseInt(choice);
                            newCharacter.setSpeed(iAge);
                        } catch (NumberFormatException e) {
                            System.out.println("Lets try putting a number in, okay?");
                            break;
                        }
                        characterList.add(newCharacter);    //Add the new element to the List
                        currentC=characterList.size()-1;
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
                        System.out.println("Constitution: " + rollMe);
                        characterList.get(currentC).setConstitution(rollMe);
                        rollMe = test.generateAbilityScoreStandard();
                        System.out.println("Strength: " + rollMe);
                        characterList.get(currentC).setStrength(rollMe);//Counter for character
                        break;
                    }
                    case ("edit"): {
                        System.out.println("Which entry would you like to edit? (First,Last)");
                        choice = in.nextLine().trim();
                        nameSearch = choice.split(",");
                        if (nameSearch.length < 2) {
                            iAge = 2;
                        }
                        for (int i = 0; i < characterList.size(); i++) {
                            if (characterList.get(i).getFirstName().equalsIgnoreCase(nameSearch[0]) && characterList.get(i).getLastName().equalsIgnoreCase(nameSearch[1]) && iAge != 2) {
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
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Charisma? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                System.out.println("Charisma: " + rollMe);
                                characterList.get(currentC).setCharisma(rollMe);
                            }
                        }
                        choice = "R";
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Intelligence? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                characterList.get(currentC).setIntelligence(rollMe);
                                System.out.println("Intelligence: " + rollMe);
                            }
                        }
                        choice = "R";
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Wisdom? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                System.out.println("Wisdom: " + rollMe);
                                characterList.get(currentC).setWisdom(rollMe);
                            }
                        }
                        choice = "R";
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Dexterity? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                System.out.println("Dexterity: " + rollMe);
                                characterList.get(currentC).setDexterity(rollMe);
                            }
                        }
                        choice = "R";
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Constitution? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                System.out.println("Constitution: " + rollMe);
                                characterList.get(currentC).setConstitution(rollMe);
                            }
                        }
                        choice = "R";
                        while (!choice.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to edit Strength? (Y/N)");
                            choice = in.nextLine().trim();
                            if (choice.equalsIgnoreCase("Y")) {
                                rollMe = test.generateAbilityScoreStandard();
                                System.out.println("Strength: " + rollMe);
                                characterList.get(currentC).setStrength(rollMe);
                            }
                        }
                        break;
                        
                    }
                    case ("print"): {
                        System.out.println();
                    for (int i = 0; i < characterList.size(); i++) {
                    System.out.println(characterList.get(i).toString());
                    System.out.println();
                }
                        break;
                    }
                    case ("search"): {
                        System.out.println("Search Name: (First,Last)");
                        choice = in.nextLine().trim();
                        nameSearch = choice.split(",");
                        iAge = 1;
                        for (int i = 0; i < characterList.size(); i++) {
                            if (characterList.get(i).getFirstName().equalsIgnoreCase(nameSearch[0])) {
                                currentC = i;
                                iAge = 2;
                                System.out.println("Found " + characterList.get(i).getFirstName() + " " + characterList.get(i).getLastName());
                            }
                            if (nameSearch.length == 1) {
                                iAge = 3;
                            }
                            if (iAge != 3) {
                                if (characterList.get(i).getLastName().equalsIgnoreCase(nameSearch[1])) {
                                    currentC = i;
                                    iAge = 2;
                                    System.out.println("Found " + characterList.get(i).getFirstName() + " " + characterList.get(i).getLastName());
                                }
                            }
                        }
                        break;
                    }
                    case ("simulate"): {
//                        Die die1 = new Die(currentC);
//                        int rolled = die1.getFaceValue();
//                        newCharacter.printRand(rolled);
//                        die1 = new Die(currentC);
//                        rolled = die1.getFaceValue();
//                        newCharacter.printRand(rolled);
//                        newCharacter.walk(rolled, "North");
//                        newCharacter.run(rolled, "West");
                        break;
                    }
                    
                    case ("exit"): {
                        System.out.println("Exit"); //Exit
                        stop = 1;
                        FileIO.printMe(RPCharacter.convertCharacterListToHashMapList(characterList), CHARACTER_FILE_PATH);
                        break;
                    }
                    default: {
                        System.out.println("Try again ");   //Anything thats not recognized
                    }
                }
            }
        }
}
