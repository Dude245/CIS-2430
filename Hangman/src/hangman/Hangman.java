package hangman;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

/**
 *  
 *
 * @author Nathan
 * The Hangman Program
 */

public class Hangman {
/**
 * 
 * Main loop, play or prepare goes to the same loop of creating words
 * create your word, strip it of characters
 * Guess word ignoring case 
 * 
 */
    public static void main(String[] args) {
        //Declare variables, not war
        int Loop = 1;
        Scanner in = new Scanner(System.in, "UTF-8");
        String guess;
        String choice;
        String words;
        String word;
        int play = 1;
        String[] tokens = null;
        int forCount;
        //Start the intoduction to the progam, get line of text
        while (play == 1) {
            System.out.println("Welcome to Hangman!");
            System.out.println("Please select from the options below:");
            System.out.println("Play");
            System.out.println("Prepare");
            System.out.println("Perish \n");
            choice = in.nextLine();
            choice = choice.toLowerCase(Locale.ENGLISH);
            switch (choice) {
                case "prepare": {
                    System.out.println("Please input a single line of words!");
                    words = in.nextLine();
                    //Split line of text into seperate words, select random word
                    String delimit = "[ .?!:,-]+";
                    tokens = words.split(delimit);
                    Random random = new Random();
                    int r = random.nextInt(tokens.length);
                    word = tokens[r];
                    //Print out how many characters the word is (For easier guessing)
                    System.out.print("Word you are guessing: ");
                    for (forCount = 0; forCount < word.length(); forCount++) {
                        System.out.print("_ ");
                    }
                    System.out.println();
                    while (Loop == 1) {
                        System.out.println("Please Input your Guess (Or Q to quit)");
                        guess = in.nextLine();
                        //Check to see if its you can quit
                        boolean equals = guess.equalsIgnoreCase(tokens[r]);
                        boolean exit = guess.equalsIgnoreCase("Q");
                        //Statements at the end of the guess
                        if (exit == true) {
                            Loop = 0;
                            System.out.println("Okay, come back soon!");
                        }
                        if (equals == true) {
                            System.out.println("Yay! You got it");
                            System.out.println();
                            Loop = 0;
                        } else {
                            System.out.println("No! Try again!");
                        }
                    }
                    break;
                }
                case "play": {
                    System.out.println("Oops! You need to add words first!");
                    System.out.println("Please input a single line of words!");
                    words = in.nextLine();
                    //Split line of text into seperate words, select random word
                    String delimit = "[ .?!:,-]+";
                    tokens = words.split(delimit);
                    Random random = new Random();
                    int r = random.nextInt(tokens.length);
                    word = tokens[r];
                    //Print out how many characters the word is (For easier guessing)
                    System.out.print("Word you are guessing: ");
                    for (forCount = 0; forCount < word.length(); forCount++) {
                        System.out.print("_ ");
                    }
                    System.out.println();
                    while (Loop == 1) {
                        System.out.println("Please Input your Guess (Or Q to quit)");
                        guess = in.nextLine();
                        //Check to see if its you can quit
                        boolean equals = guess.equalsIgnoreCase(tokens[r]);
                        boolean exit = guess.equalsIgnoreCase("Q");
                        //Statements at the end of the guess
                        if (exit == true) {
                            Loop = 0;
                            System.out.println("Okay, come back soon!");
                        }
                        if (equals == true) {
                            System.out.println("Yay! You got it");
                            System.out.println();
                            Loop = 0;
                        } else {
                            System.out.println("No! Try again!");
                        }
                    }
                    break;
                }
                case "perish": {
                    play = 0;
                    Loop = 0;
                    break;
                }
                default: {
                    System.out.println("Not an option!");
                }
            }
        }
    }
}
