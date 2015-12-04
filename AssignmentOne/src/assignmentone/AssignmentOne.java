package assignmentone;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nathan Reymer
 */
public class AssignmentOne {

    public static void main(String[] args) {
        //Declare Variable, Not War
        int Stop = 1;
        int lNum = 0;
        String choice;
        String input;
        String Search;
        String[] check;
        String[] List = new String[500];
        System.out.println("Welcome to the Library Search Program");
        //Start main loop
        while (Stop == 1) {
            //User cannot enter more than 500 books
            if (lNum > 450) {
                System.out.println("There is a 500 book limit! You are at: " + lNum);
            } else if (lNum == 500) {
                System.out.println("Im deleteing your last entry!");
                lNum--;
            }
            //Display user options
            System.out.println("You currently have: " + lNum + " Books \n");
            System.out.println("Please choose from one of the following options:");
            System.out.println("Add");
            System.out.println("Search");
            System.out.println("Display");
            System.out.println("Quit \n");
            Scanner in = new Scanner(System.in, "UTF-8");
            choice = in.nextLine();
            //Convert inut to lower case, compare with switch
            choice = choice.toLowerCase(Locale.ENGLISH);
            switch (choice) {
                case "add": {
                    System.out.print("Book to add: ");
                    input = in.nextLine();
                    check = input.split(";");
                    if (check.length != 3) {//Check to see if it's actually a book
                        System.out.println("Oops! You havent entered a valid book! Use ; please \n");
                    } else {
                        //Strip characters I do not want
                        input = input.replaceAll("\"", "");
                        input = input.replaceAll(";", " ");
                        List[lNum] = (input);
                        // Duplication Check
                        for (int Check = 0; Check < lNum; Check++) {
                            boolean equals = input.equalsIgnoreCase(List[Check]);
                            if (equals == true) {
                                System.out.println("Duplicate Entry!");
                                lNum--;
                            }
                        }
                        lNum++;
                    }

                    break;
                }
                case "search": {
                    System.out.print("Search: ");
                    System.out.println("Mutiple items should be seperated with a ','");
                    Search = in.nextLine();
                    System.out.println();
                    //Where the magic happens
                    librarySearch(Search, List, lNum);
                    break;
                }
                case "display": {
                    //Simple print of array
                    System.out.println("Array: \n");
                    for (int count = 0; count < lNum; count++) {
                        System.out.println(List[count]);
                    }
                    break;
                }
                case "quit": {
                    //Exit statment
                    System.out.println("Quit");
                    Stop = 0;
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

    public static void librarySearch(String search, String[] array, int lNum) {
        //Declare Variables, not War
        String newArray;
        int noFound;
        String patternString;
        noFound = 0;
        Pattern pattern;
        String[] tokens;
        //Split each search item
        tokens = search.split(",");
        //Set search to ignore case, add up all items
        search = "(?i)";
        for (int searchCount = 0; searchCount < tokens.length; searchCount++) {
            search = search + ("(.*" + tokens[searchCount] + ".*)");
        }
        patternString = (search);
        pattern = Pattern.compile(patternString);
        for (int x = 0; x < lNum; x++) {
            //Search each string for that item
            newArray = array[x];
            Matcher matcher = pattern.matcher(newArray);
            boolean matches = matcher.matches();
            if (matches == true) {
                System.out.println("Found in book " + (x + 1) + ": " + newArray);
                noFound++;
            }
        }
        if (noFound == 0) {
            //If nothing found, output to user
            System.out.println("Sorry, I could't find any results!");
        }
    }
}
