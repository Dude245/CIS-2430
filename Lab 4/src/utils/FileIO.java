/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import RPCharacter.RPCharacterManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static rpcharacter.RPCharacterManager.characterList;
//import static rpcharacter.RPCharacterManager.characterList;

/**
 *
 * @author Nathan Reymer 0797359
 */
public class FileIO {

    public static ArrayList<HashMap<String, String>> readDataFromFile(String file) {
        ArrayList<HashMap<String, String>> characterInfo = new ArrayList();
        HashMap currentHash = new HashMap();
        String currentLineSplit[] = null;
        String currentLine;
        final int VALUE = 1;
        final int KEY = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            currentLine = br.readLine();
            while (currentLine != null) {

                //decide what to do based on info from current line in the file
                if (currentLine.equalsIgnoreCase("[character]")) {

                } else if (currentLine.equals("")) {
                    characterInfo.add(currentHash);
                    currentHash = new HashMap();

                } else {//store the values found in the file
                    currentLineSplit = currentLine.split("=");
                    currentHash.put(currentLineSplit[KEY], currentLineSplit[VALUE]);
                }

                //prepare all local variables for next iteration of loop
                currentLine = br.readLine();
                currentLineSplit = null;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error file not found!");
            Logger.getLogger(RPCharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Problem reading file!");
            Logger.getLogger(RPCharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        System.out.println("File Read Succesfuly");
        return characterInfo;
    }

    /**
     * takes a list of hash maps, and writes them to a file in a specific format
     * so they may be easily read again later
     *
     * @param data
     * @param file
     */
    public void printMe(ArrayList<HashMap<String, String>> data, String filePath) {
        Iterator<HashMap<String, String>> it = data.iterator();
        HashMap<String, String> currentHash;
        File file = new File(filePath);
        String saveContent = "";
        BufferedWriter bw;
        FileWriter fw;

        while (it.hasNext()) {
            currentHash = it.next();

            saveContent += "[character]" + System.getProperty("line.separator");
            saveContent += "Class=" + currentHash.get("Class") + System.getProperty("line.separator");
            saveContent += "FirstName=" + currentHash.get("FirstName") + System.getProperty("line.separator");
            saveContent += "LastName=" + currentHash.get("LastName") + System.getProperty("line.separator");
            saveContent += "age=" + currentHash.get("age") + System.getProperty("line.separator");
            saveContent += "STR=" + currentHash.get("STR") + System.getProperty("line.separator");
            saveContent += "DEX=" + currentHash.get("DEX") + System.getProperty("line.separator");
            saveContent += "CON=" + currentHash.get("CON") + System.getProperty("line.separator");
            saveContent += "INT=" + currentHash.get("INT") + System.getProperty("line.separator");
            saveContent += "WIS=" + currentHash.get("WIS") + System.getProperty("line.separator");
            saveContent += "CHA=" + currentHash.get("CHA") + System.getProperty("line.separator");
            saveContent += "level=" + currentHash.get("level") + System.getProperty("line.separator");
            saveContent += "speed=" + currentHash.get("speed") + System.getProperty("line.separator");
            saveContent += System.getProperty("line.separator");
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(RPCharacterManager.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error creating new save file.");
            }
        }

        try {

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(saveContent);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(RPCharacterManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error saving file.");
        }

    }
}
