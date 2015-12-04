package assignmentthree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nathan Reymer This program takes in Added books/Journals Then they
 * can be searched by typing in Keywords
 */
public class AssignmentThree {

    /**
     * Creates the List for everything now
     */
    public static ArrayList<Refrence> rList = new ArrayList<>();

/**
 * Start the main program! This program takes in Added books/Journals Then
     * they can be searched by typing in Keywords
     */
    public static void main(String[] args) throws IOException {
        //Declare Variables, Not War
        String fpi,fpo;
        if (args.length < 2) {
            fpi = "./data/Database.txt";
           fpo = "./data/Database.txt";
           System.out.println("No arguments, using default values");
        }
        else
        {
            fpi=args[0];
            fpo=args[1];
        }
        //Do some nice hashMap stuff from Lab 3
        ArrayList<HashMap<String, String>> libHashList;
        libHashList = FileIO.readDataFromFile(fpi);
        rList = FileIO.convertHashMapListToLibList(libHashList);
         Map lMap = new HashMap();
                for (int i = 0; i < rList.size(); i++) {
            String[] splitted = rList.get(i).getTitle().split(" ");
            int longWords = i;
            //Load the title into a hashmap
            for (String split : splitted) {
                if (split.isEmpty() == false) {
                    lMap.put(longWords, split.toLowerCase());
                    longWords++;
                }
            }
        }
        int Stop = 1;
        String choice;
        String input;
        Journal J = new Journal();
        Book B = new Book();
        FileIO FileIO = new FileIO();
        Refrence Search = new Refrence();
        System.out.println("Welcome to the Library Search Program");
        //Start main loop
        while (Stop == 1) {
            //Display user options
            System.out.println("You currently have: " + rList.size() + " Entries");
            System.out.println("Please choose from one of the following options:");
            System.out.println("Add");
            System.out.println("Search");
            System.out.println("Display");
            System.out.println("Quit \n");
            Scanner in = new Scanner(System.in, "UTF-8");
            choice = in.nextLine();
            //Convert inut to lower case, compare with switch
            choice = choice.toLowerCase(Locale.ENGLISH);
            //Take shortcut options
            switch (choice) {
                case "a":
                    choice = "add";
                    break;
                case "s":
                    choice = "search";
                    break;
                case "d":
                    choice = "display";
                    break;
                case "q":
                    choice = "quit";
                    break;
            }
            switch (choice) {
                case "add": {
                    System.out.println("(1)Book or (2)Journal?");
                    input = in.nextLine().trim();
                    switch (input) {
                        case "1": {
                            B.bAdd(rList);
                            break;
                        }
                        case "2": //For Journal
                            J.jAdd(rList);
                            break;
                    }
                    break;
                }
                case "search": {
                    System.out.print("Search: \n");
                       Search.Search(rList,lMap);                   
                    break;
                }
                case "display": {
                    //Simple print of array
                    System.out.println("");
                    for (int t = 0; t < rList.size(); t++) {
                        System.out.println(rList.get(t).toString());
                    }
                    break;
                }
                case "quit": {
                    //Exit statment
                    System.out.println("Quit");
                    Stop = 0;
                    FileIO.PrintFile(rList, fpo);
                    System.out.println("Wrote file to: "+fpo);
                    break;
                }
                default: {
                    //Defensive Response
                    System.out.println("Not a choice!");
                    break;
                }
            }
        }
    }
}
