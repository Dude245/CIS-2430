/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Nathan
 */
public class FileIO {

    public static ArrayList<HashMap<String, String>> readDataFromFile(String file) throws FileNotFoundException, IOException {
        ArrayList<HashMap<String, String>> libInfo = new ArrayList();
        int error=0;
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
                if (currentLine.equalsIgnoreCase("[Entry]")) {
                } else if (currentLine.equals("")) {
                    libInfo.add(currentHash);
                    currentHash = new HashMap();

                } else {//store the values found in the file
                    currentLineSplit = currentLine.split("=");
                    currentHash.put(currentLineSplit[KEY], currentLineSplit[VALUE]);
                }

                //prepare all local variables for next iteration of loop
                currentLine = br.readLine();
                currentLineSplit = null;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Sorry, one of more entrys is corrupt. It will be deleted on close.");
            error++;
        }
        if(error==0)
        {
        System.out.println("File Read Succesfuly");
        }
        return libInfo;
    }

    public static Refrence convertHashMapToLib(HashMap<String, String> hash) {
        Refrence newEnt;
        Iterator it = hash.entrySet().iterator();
        switch ((String) hash.get("Type")) {
            case "Book":
                //class is wizzard
                newEnt = new Book();

                break;
            case "Journal":
                //class is fighter
                newEnt = new Journal();
                break;
            default:
                newEnt = new Book();
        }
        while (it.hasNext()) {

            Map.Entry hashEntry = (Map.Entry) it.next();

            switch (((String) hashEntry.getKey()).toLowerCase()) {
                case "type":
                    newEnt.setType((String) hashEntry.getValue());
                    break;
                case "callnum":
                    newEnt.setCallN((String) hashEntry.getValue());
                    break;
                case "authors":
                    newEnt.setAuthor((String) hashEntry.getValue());
                    break;
                case "title":
                    newEnt.setTitle((String) hashEntry.getValue());
                    break;
                case "publisher":
                    newEnt.setPublish((String) hashEntry.getValue());
                    break;
                case "orginization":
                    newEnt.setOrg((String) hashEntry.getValue());
                    break;
                case "year":
                    newEnt.setYear((String) hashEntry.getValue());
                    break;
            }

        }
        return newEnt;
    }

    public static ArrayList<Refrence> convertHashMapListToLibList(ArrayList<HashMap<String, String>> hashList) {
        Iterator<HashMap<String, String>> it = hashList.iterator();
        ArrayList<Refrence> libList = new ArrayList();
        Refrence newEnt;

        while (it.hasNext()) {
            newEnt = convertHashMapToLib(it.next());
            libList.add(newEnt);
        }

        return libList;
    }

    /**
     * takes a File info and stores into in a hash map
     *
     * @param lib has all the library information
     * @return
     */
    public static HashMap<String, String> convertLibToHashMap(Refrence lib) {
        HashMap<String, String> hash = new HashMap<>();

        if (lib.getType().equals("Book")) {
            hash.put("type", "book");
            hash.put("callnum", lib.getCallN());
            hash.put("authors", lib.getAuthor());
            hash.put("title", lib.getTitle());
            hash.put("publisher", lib.getPub());
            hash.put("year", lib.getYear());
        } else {
            hash.put("type", "journal");
            hash.put("callnum", lib.getCallN());
            hash.put("title", lib.getTitle());
            hash.put("org", lib.getOrg());
            hash.put("year", lib.getYear());

        }

        return hash;
    }

    /**
     * takes a list of Library  and stores into in a list of hash maps
     *
     * @param libList holds all info for the library
     * @return
     */
    public static ArrayList<HashMap<String, String>> convertLibListToHashMapList(ArrayList<Refrence> libList) {
        Iterator<Refrence> it = libList.iterator();
        ArrayList<HashMap<String, String>> hashList = new ArrayList<>();
        HashMap<String, String> currentHash;

        while (it.hasNext()) {
            currentHash = convertLibToHashMap(it.next());
            hashList.add(currentHash);
        }

        return hashList;
    }

    void PrintFile(ArrayList<Refrence> rList, String FilePath) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter(FilePath, "UTF-8")) {

            for (int i = 0; i < rList.size(); i++) {
                writer.println("[Entry]");
                if (rList.get(i).getType().equalsIgnoreCase("Book")) {
                    writer.println("Type=Book");
                    writer.println("CallNum=" + rList.get(i).getCallN());
                    writer.println("Authors=" + rList.get(i).getAuthor());
                    writer.println("Title=" + rList.get(i).getTitle());
                    writer.println("Publisher=" + rList.get(i).getPub());
                    writer.println("Year=" + rList.get(i).getYear());

                } else {
                    writer.println("Type=Journal");
                    writer.println("CallNum=" + rList.get(i).getCallN());
                    writer.println("Title=" + rList.get(i).getTitle());
                    writer.println("Orginization=" + rList.get(i).getOrg());
                    writer.println("Year=" + rList.get(i).getYear());
                }
                writer.println("");
            }
        }

    }

}
