package assignmentwo;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nathan Reymer This program takes in Added books/Journals Then they
 * can be searched by typing in Keywords
 */
public class AssignmentTwo {

    /**
     * Creates the List for Books
     */
    public final static ArrayList<Book> bList = new ArrayList<>();
    /**
     * Creates the list for Journals
     */
    public final static ArrayList<Journal> jList = new ArrayList<>();

    /**
     *
     * Start the main program! This program takes in Added books/Journals Then
     * they can be searched by typing in Keywords
     */
    public static void main(String[] args) {
        //Declare Variables, Not War
        int Stop = 1;
        int bNum = 0;
        int jNum = 0;
        String search;
        String choice;
        String input;
        String[] searchParts;
        searchParts = new String[2];
        int yStart = 0;
        int yEnd = 0;
        int myYear;
        int dup;
        String[] st;
        char n;
        char n4;
        int yTemp;
        String found;
        String titleSearch[];
        System.out.println("Welcome to the Library Search Program");
        //Start main loop
        while (Stop == 1) {
            //Display user options
            Book bEnt = new Book();
            Journal jEnt = new Journal();
            System.out.println("You currently have: " + bNum + " Books and " + jNum + " Jorunals \n");
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
                    System.out.print("(1) For Book (2) For Journal ");
                    input = in.nextLine().trim();
                    switch (input) {
                        case "1"://For BOOK
                            dup = 0;
                            System.out.print("What is the Call Number?: ");
                            input = in.nextLine().trim();
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Call Number");
                                    input = in.nextLine().trim();
                                }
                            }
                            bEnt.setCallN(input);
                            //Duplicate check 1
                            for (int i = 0; i < bList.size(); i++) {
                                if (bList.get(i).getCallN().equalsIgnoreCase(input)) {
                                    dup++;
                                }
                            }
                            System.out.print("Who is (are) the Authors?: ");
                            input = in.nextLine().trim();
                            bEnt.setAuthor(input);
                            System.out.print("What is the title?: ");
                            input = in.nextLine().trim();
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Title");
                                    input = in.nextLine().trim();
                                }
                            }
                            bEnt.setTitle(input);
                            System.out.print("Who is the publisher?: ");
                            input = in.nextLine().trim();
                            bEnt.setPublish(input);
                            System.out.print("What is the year of Publication?: ");
                            input = in.nextLine().trim();
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Year");
                                    input = in.nextLine().trim();
                                }
                            }
                            bEnt.setYear(input);
                            //Duplicate check 2
                            for (int i = 0; i < bList.size(); i++) {
                                if (bList.get(i).getYear().equalsIgnoreCase(input)) {
                                    dup++;
                                }
                            }
                            //Duplicate for callNumber and Year
                            if (dup == 2) {
                                System.out.println();
                                System.out.println("Seems like you have a duplicate! \n");
                                break;
                                //If no problems, add to the arrayList
                            } else {
                                bNum++;
                                bList.add(bEnt);
                                break;
                            }

                        case "2": //For Journal
                            dup = 0;
                            System.out.print("What is the Call Number?: ");
                            input = in.nextLine().trim();
                            jEnt.setCallN(input);
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Call Number");
                                    input = in.nextLine().trim();
                                }
                            }
                            //Duplication Check 1
                            for (int i = 0; i < jList.size(); i++) {
                                if (jList.get(i).getCallN().equalsIgnoreCase(input)) {
                                    dup++;
                                }

                            }
                            System.out.print("What is the title?: ");
                            input = in.nextLine().trim();
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Title");
                                    input = in.nextLine().trim();
                                }
                            }
                            jEnt.setTitle(input);
                            System.out.print("What orginization?: ");
                            input = in.nextLine().trim();
                            jEnt.setOrg(input);
                            System.out.print("What is the year of Publication?: ");
                            input = in.nextLine().trim();
                            if ("".equals(input)) {
                                while ("".equals(input)) {
                                    System.out.println("You need to enter a Year");
                                    input = in.nextLine().trim();
                                }
                            }
                            jEnt.setYear(input);
                            //Duplication check 2
                            for (int i = 0; i < jList.size(); i++) {
                                if (jList.get(i).getYear().equalsIgnoreCase(input)) {
                                    dup++;
                                }
                            }
                            //Duplication kill
                            if (dup == 2) {
                                System.out.println();
                                System.out.println("Seems like you have a duplicate! \n");
                                break;
                                //Add to arrayList
                            } else {
                                jNum++;
                                jList.add(jEnt);
                                break;
                            }
                        //Generic Message
                        default: {
                            System.out.println("Not an option!");
                        }
                    }
                }
                break;
                case "search": {
                    System.out.print("Search: ");
                    System.out.println("(1) Book or (2)Journal?");
                    input = in.nextLine().trim();
                    switch (input) {
                        case "1": //For Book
                            System.out.println("Title: ");
                            search = in.nextLine().trim();
                            searchParts[0] = search;
                            System.out.println("Call Number:");
                            search = in.nextLine().trim();
                            searchParts[1] = search;
                            System.out.println("Year:");
                            search = in.nextLine().trim();
                            //Split year string to usable info
                            if (search == null) {
                                search = "";
                            }
                            st = search.split("\\p{Punct}");

                            if (search.length() < 5 && !"".equals(search)) {
                                n4 = 'n';
                                n = search.charAt(0);

                            } else if (!"".equals(search)) {
                                n4 = search.charAt(4);
                                n = search.charAt(0);
                            } else {
                                n4 = 'n';
                                n = 'n';
                            }
                            //Set start and end year variables based on string
                            if (st.length == 2 && n != '-' && !"".equals(search)) {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = Integer.parseInt(st[1]);
                            } else if (st.length == 1 && !"".equals(search) && search.length() < 5) {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = Integer.parseInt(st[0]);
                            } else if (st.length == 1 && !"".equals(search) && n4 == '-') {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = 9999;
                            } else if (st.length == 2 && !"".equals(search) && n == '-') {
                                yStart = 1000;
                                yEnd = Integer.parseInt(st[1]);
                            }
                            //Debug
//                    System.out.println(st.length);
//                     System.out.println(yStart);
//                      System.out.println(yEnd);
//                       System.out.println(n);
//                        System.out.println(n4);
                            //Reset the found check
                            found = "";
                            for (int i = 0; i < bList.size(); i++) {
                                found = "";
                                yTemp = yStart;
                                String patternString;
                                Pattern pattern;
                                //Regex whole word search ignoring case for every word
                                search = "(?i)";
                                titleSearch=searchParts[0].split(" ");
                                //Start RegEx compare string
                                    for (int searchCount = 0; searchCount < titleSearch.length; searchCount++) {
            search = search + ".*(.*\\b"+ titleSearch[searchCount] + "\\b.*).*";
        }
                                patternString = (search);
                                pattern = Pattern.compile(patternString);
                                Matcher matcher = pattern.matcher(bList.get(i).getTitle());
                                boolean matches = matcher.matches();
                                //Will be true if search title is blank
                                if (matches == true) {
                                    //If title isnt actually blank, add
                                    if (!"".equals(searchParts[0])) {
                                        found = found + "title";
                                    }
                                    if (bList.get(i).getCallN().equalsIgnoreCase(searchParts[1]) || "".equals(searchParts[1])) {
                                        if (!"".equals(searchParts[1])) {
                                            found = found + "callN";
                                        }
                                        if (yStart != 0 && yEnd != 0) {
                                            do {
                                                //Loop through years entered
                                                myYear = Integer.parseInt(bList.get(i).getYear());
                                                if (myYear == (yTemp)) {
                                                    found = found + "Year";
                                                }
                                                yTemp++;
                                            } while (yEnd > yTemp);
                                        }
                                    }

                                }
                                //If found matches entered keywords, youre solid!
                                if (!"".equalsIgnoreCase(found)) {
                                    System.out.println();
                                    System.out.print("Found book: \n" + "Call Number: " + bList.get(i).getCallN() + "\n" + "Author(s): " + bList.get(i).getAuthor() + " \n"
                                            + "Title : " + bList.get(i).getTitle() + " \n" + "Publisher: " + bList.get(i).getPub() + "\n" + "Year: " + bList.get(i).getYear() + "\n");
                                }
                            }//Failure message
                            if ("".equals(found)) {
                                System.out.println("\nNo items found");
                            }

                            break;
                        //Same comments as BOOK, just searching jList instead of bList
                        case "2": { //Journal
                            System.out.println("Title: ");
                            search = in.nextLine().trim();
                            searchParts[0] = search;
                            System.out.println("Call Number:");
                            search = in.nextLine().trim();
                            searchParts[1] = search;
                            System.out.println("Year:");
                            search = in.nextLine().trim();
                            if (search == null) {
                                search = "";
                            }
                            st = search.split("\\p{Punct}");
                            if (search.length() < 5 && !"".equals(search)) {
                                n4 = 'n';
                                n = search.charAt(0);

                            } else if (!"".equals(search)) {
                                n4 = search.charAt(4);
                                n = search.charAt(0);
                            } else {
                                n4 = 'n';
                                n = 'n';
                            }

                            if (st.length == 2 && n != '-' && !"".equals(search)) {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = Integer.parseInt(st[1]);
                            } else if (st.length == 1 && !"".equals(search) && search.length() < 5) {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = Integer.parseInt(st[0]);
                            } else if (st.length == 1 && !"".equals(search) && n4 == '-') {
                                yStart = Integer.parseInt(st[0]);
                                yEnd = 9999;
                            } else if (st.length == 2 && !"".equals(search) && n == '-') {
                                yStart = 1000;
                                yEnd = Integer.parseInt(st[1]);
                            }
                            found = "";
                            for (int i = 0; i < jList.size(); i++) {

                                found = "";
                                yTemp = yStart;
                                String patternString;
                                Pattern pattern;
                                search = "(?i)";
                                titleSearch=searchParts[0].split(" ");
                                //Start RegEx compare string
                                    for (int searchCount = 0; searchCount < titleSearch.length; searchCount++) {
            search = search + ".*(.*\\b"+ titleSearch[searchCount] + "\\b.*).*";
        }
                                patternString = (search);
                                pattern = Pattern.compile(patternString);
                                Matcher matcher = pattern.matcher(jList.get(i).getTitle());
                                boolean matches = matcher.matches();
                                if (matches == true) {
                                    if (!"".equals(searchParts[0])) {
                                        found = found + "title";
                                    }
                                    if (jList.get(i).getCallN().equalsIgnoreCase(searchParts[1]) || "".equals(searchParts[1])) {
                                        if (!"".equals(searchParts[1])) {
                                            found = found + "callN";
                                        }
                                        if (yStart != 0 && yEnd != 0) {
                                            do {
                                                myYear = Integer.parseInt(jList.get(i).getYear());
                                                if (myYear == (yTemp)) {
                                                    found = found + "Year";
                                                }
                                                yTemp++;
                                            } while (yEnd > yTemp);
                                        }
                                    }

                                }
                                //Print found entrys 
                                if (!"".equalsIgnoreCase(found)) {
                                    System.out.println();
                                    System.out.print("Found Journal: \n" + "Call Number: " + jList.get(i).getCallN() + "\n" + "Author(s): "
                                            + "Title : " + jList.get(i).getTitle() + " \n" + "Orginization: " + jList.get(i).getOrg() + "Year: " + jList.get(i).getYear() + "\n");
                                }
                            }
                            if ("".equals(found)) {
                                System.out.println("\nNo items found");
                            }
                        }
                    }
                }
                break;

                case "display": {
                    //Simple print of array
                    System.out.println("(1) Book or (2)Journal?");
                    input = in.nextLine().trim();
                    System.out.println("");
                    switch (input) {
                        case "1":
                            for (Book book : bList) {
                                System.out.println(book);
                            }
                            break;
                        case "2":
                            for (Journal journal : jList) {
                                System.out.println(journal);
                            }
                            break;
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
}
