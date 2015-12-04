/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nathan
 * A GUI to add, search, and display books from a file
 */
public class AssignmentGui extends JFrame implements ActionListener {
    //Declare buttons and menu items
    public static ArrayList<Refrence> rList = new ArrayList<>();
    private final String fpi = "./data/Database.txt";
    private final String fpo = "./data/Database.txt";
    private final JMenuItem add = new JMenuItem("Add");
    private final JMenuItem dis = new JMenuItem("Display");
    private final JMenuItem sExit = new JMenuItem("Save and Exit");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JButton nextChar = new JButton("Next Character");
    private final JButton accept = new JButton("Accept");
    private final JButton cancel = new JButton("Cancel");
    private final JButton searchB = new JButton("Search");

    JMenuItem search = new JMenuItem("Search");
    int currentC = 0;
    int dup = 0;
    JFrame frame = new JFrame("Library Search");
    JMenuBar menuBar = new JMenuBar();
    JTextArea menuBox = new JTextArea();
    JMenu menu = new JMenu("Commands");

    //Labels and text fields
    JLabel typeLbl = new JLabel("Type:");
    String Types[] = {"Book", "Journal"};
    JComboBox type = new JComboBox(Types);
    JLabel callLbl = new JLabel("Call No:");
    JTextField call = new JTextField();
    JLabel authLbl = new JLabel("Authors:");
    JTextField auth = new JTextField();
    JLabel titleLbl = new JLabel("Title:");
    JTextField title = new JTextField();
    JLabel pubLbl = new JLabel("Publisher:");
    JTextField pub = new JTextField();
    JLabel orgLbl = new JLabel("Organization:");
    JTextField org = new JTextField();
    JLabel yearLbl = new JLabel("Year:");
    JTextField year = new JTextField();
    JButton resetA = new JButton("Reset");
    JButton resetS = new JButton("Reset");
    JButton addB = new JButton("Add");
    JLabel messages = new JLabel("Messages:");
    JLabel sResults = new JLabel("Search Results:");
    JLabel addJ = new JLabel("Adding a Journal Entry");
    JLabel addBo = new JLabel("Adding a Book Entry");
    JLabel searchLbl = new JLabel("Search");
    JTextArea output = new JTextArea();
    JLabel keyWLbl = new JLabel("Title Keywords:");
    JTextField keyW = new JTextField();
    JLabel sYearLbl = new JLabel("Start Year:");
    JLabel eYearLbl = new JLabel("End Year:");
    JTextField sYear = new JTextField();
    JTextField eYear = new JTextField();
    JScrollPane scroll = new JScrollPane(output);
    String Classes[] = {"Book", "Journal"};
    JComboBox typeChoose = new JComboBox(Classes);

    int cFlag = 0;
    private final JScrollPane outPanel = new JScrollPane(output);
    
//This class contains the GUI elements
    public AssignmentGui() throws InterruptedException, IOException {
        //Use the Hashmap and data file from previous assignments
        ArrayList<HashMap<String, String>> libHashList;
        libHashList = FileIO.readDataFromFile(fpi);
        //Create the refrencelist
        rList = FileIO.convertHashMapListToLibList(libHashList);
        //Create the menu bar.
        outPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Add the items to the menu/GUI
                menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        add.addActionListener(this);
        sExit.addActionListener(this);
        exit.addActionListener(this);
        dis.addActionListener(this);
        nextChar.addActionListener(this);
        accept.addActionListener(this);
        cancel.addActionListener(this);
        typeChoose.addActionListener(this);
        search.addActionListener(this);
        addB.addActionListener(this);
        resetA.addActionListener(this);
        resetS.addActionListener(this);
        searchB.addActionListener(this);
        typeChoose.addActionListener(this);
        frame.setLayout(null);
        menu.add(add);
        menu.add(search);
        menu.add(dis);
        menu.add(sExit);
        menu.add(exit);
        frame.setBackground(Color.white);
        frame.setSize(400, 510);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBox.setBounds(0, 0, 400, 510);
        menuBox.setVisible(true);
        menuBox.setEditable(false);
        menuBox.setText("Welcome to the Library Search \n\n Choose an option. "
                + "Add, Search, Display or exit.\n");
        
        //Set items to invisable/Set where they are
        frame.add(menuBox);
        typeLbl.setBounds(40, 40, 100, 40);
        frame.add(typeLbl);
        callLbl.setBounds(40, 80, 100, 40);
        frame.add(callLbl);
        typeChoose.setBounds(110, 50, 80, 20);
        frame.add(typeChoose);
        call.setBounds(110, 90, 150, 20);
        frame.add(call);
        titleLbl.setBounds(40, 120, 100, 40);
        frame.add(titleLbl);
        title.setBounds(110, 130, 150, 20);
        frame.add(title);
        authLbl.setBounds(40, 160, 100, 40);
        frame.add(authLbl);
        auth.setBounds(110, 170, 150, 20);
        frame.add(auth);
        orgLbl.setBounds(40, 160, 100, 40);
        frame.add(orgLbl);
        org.setBounds(120, 170, 150, 20);
        frame.add(org);
        pubLbl.setBounds(40, 200, 100, 40);
        frame.add(pubLbl);
        pub.setBounds(110, 210, 150, 20);
        frame.add(pub);
        yearLbl.setBounds(40, 240, 100, 40);
        frame.add(yearLbl);
        year.setBounds(110, 250, 150, 20);
        frame.add(year);
        resetA.setBounds(300, 100, 80, 40);
         resetS.setBounds(300, 100, 80, 40);
        frame.add(resetA);
        frame.add(resetS);
        addB.setBounds(300, 200, 80, 40);
        frame.add(addB);
        searchB.setBounds(300, 200, 80, 40);
        frame.add(searchB);
        keyWLbl.setBounds(40, 120, 100, 40);
        frame.add(keyWLbl);
        keyW.setBounds(130, 130, 150, 20);
        frame.add(keyW);
        sYearLbl.setBounds(40, 160, 100, 40);
        frame.add(sYearLbl);
        eYearLbl.setBounds(40, 200, 100, 40);
        frame.add(eYearLbl);
        sYear.setBounds(110, 170, 150, 20);
        frame.add(sYear);
        eYear.setBounds(110, 210, 150, 20);
        frame.add(eYear);
        
        //Add more items
        addJ.setBounds(40, 00, 200, 40);
        frame.add(addJ);
        addBo.setBounds(40, 00, 200, 40);
        frame.add(addBo);
        searchLbl.setBounds(40, 00, 200, 40);
        frame.add(searchLbl);
        
        //Add the message pane
        messages.setBounds(40, 280, 100, 20);
        sResults.setBounds(40,280,100,20);
        frame.add(sResults);
        frame.add(messages);
        messages.setVisible(false);
        output.setEditable(false);
        output.setLineWrap(false);
        outPanel.setBounds(10, 300, 370, 140);
        frame.add(outPanel);

        //Settting everything to invisable
        searchLbl.setVisible(false);
        addB.setVisible(false);
        addJ.setVisible(false);
        outPanel.setVisible(false);
        org.setVisible(false);
        orgLbl.setVisible(false);
        searchB.setVisible(false);
        keyWLbl.setVisible(false);
        keyW.setVisible(false);
        sYearLbl.setVisible(false);
        sYear.setVisible(false);
        eYearLbl.setVisible(false);
        eYear.setVisible(false);
        addB.setVisible(false);
        resetA.setVisible(false);
        resetS.setVisible(false);
        yearLbl.setVisible(false);
        year.setVisible(false);
        pubLbl.setVisible(false);
        pub.setVisible(false);
        titleLbl.setVisible(false);
        title.setVisible(false);
        auth.setVisible(false);
        authLbl.setVisible(false);
        call.setVisible(false);
        typeLbl.setVisible(false);
        typeChoose.setVisible(false);
        callLbl.setVisible(false);
        call.setVisible(false);

    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent E) {
        
        //Add refrence menu button
        if (E.getSource() == add) {

            outPanel.setBounds(10, 300, 370, 140);
            outPanel.setVisible(true);

            searchLbl.setVisible(false);
            menuBox.setVisible(false);
            searchB.setVisible(false);
            sResults.setVisible(false);
            messages.setVisible(true);
            yearLbl.setVisible(true);
            year.setVisible(true);
            pubLbl.setVisible(true);
            pub.setVisible(true);
            titleLbl.setVisible(true);
            title.setVisible(true);
            auth.setVisible(true);
            authLbl.setVisible(true);
            call.setVisible(true);
            typeLbl.setVisible(true);
            typeChoose.setVisible(true);
            callLbl.setVisible(true);
            call.setVisible(true);
            keyWLbl.setVisible(false);
            keyW.setVisible(false);
            sYearLbl.setVisible(false);
            sYear.setVisible(false);
            eYearLbl.setVisible(false);
            eYear.setVisible(false);
            addB.setVisible(true);
            resetA.setVisible(true);
            resetS.setVisible(false);
            output.setCaretPosition(output.getDocument().getLength());
        }
        //ComboBox if statement
        if (typeChoose.getSelectedItem().toString().equals("Journal")) {

            addJ.setVisible(true);
            addBo.setVisible(false);
            auth.setVisible(false);
            authLbl.setVisible(false);
            orgLbl.setVisible(true);
            org.setVisible(true);
            pubLbl.setVisible(false);
            pub.setVisible(false);
            year.setBounds(110, 210, 150, 20);
            yearLbl.setBounds(40, 200, 100, 40);

        }
        if (typeChoose.getSelectedItem().toString().equals("Book")) {

            addBo.setVisible(true);
            addJ.setVisible(false);
            
            auth.setVisible(true);
            authLbl.setVisible(true);
            orgLbl.setVisible(false);
            org.setVisible(false);
            pubLbl.setVisible(true);
            pub.setVisible(true);
            yearLbl.setBounds(40, 240, 100, 40);
            year.setBounds(110, 250, 150, 20);

        }
        //Reset button for add
        if (E.getSource() == resetA) {
       
                call.setText("");
            auth.setText("");
            title.setText("");
            pub.setText("");
            year.setText("");
            eYear.setText("");
            sYear.setText("");
            keyW.setText("");
            org.setText("");
            

        }
        //Reset button for search
           if (E.getSource() == resetS) {
       addJ.setVisible(false);
            addBo.setVisible(false);
            searchLbl.setVisible(true);
            auth.setVisible(false);
            authLbl.setVisible(false);
            pub.setVisible(false);
            pubLbl.setVisible(false);
            org.setVisible(false);
            orgLbl.setVisible(false);
                call.setText("");
            auth.setText("");
            title.setText("");
            pub.setText("");
            year.setText("");
            eYear.setText("");
            sYear.setText("");
            keyW.setText("");
            org.setText("");
            

        }
           //Displays all refrences
        if (E.getSource() == dis) {
           
            outPanel.setBounds(0, 0, 380, 440);
            outPanel.setVisible(true);
            searchLbl.setVisible(false);
            sResults.setVisible(false);
            yearLbl.setVisible(false);
            year.setVisible(false);
            pubLbl.setVisible(false);
            pub.setVisible(false);
            titleLbl.setVisible(false);
            title.setVisible(false);
            auth.setVisible(false);
            authLbl.setVisible(false);
            call.setVisible(false);
            typeLbl.setVisible(false);
            typeChoose.setVisible(false);
            org.setVisible(false);
            orgLbl.setVisible(false);

            messages.setVisible(false);
            callLbl.setVisible(false);
            call.setVisible(false);
            keyWLbl.setVisible(false);
            keyW.setVisible(false);
            sYearLbl.setVisible(false);
            sYear.setVisible(false);
            eYearLbl.setVisible(false);
            eYear.setVisible(false);
            searchB.setVisible(false);
            resetA.setVisible(false);
            addB.setVisible(false);
            resetS.setVisible(false);
             addJ.setVisible(false);
            searchLbl.setVisible(false);
            addBo.setVisible(false);

            menuBox.setVisible(false);
            for (int t = 0; t < rList.size(); t++) {
                output.append(rList.get(t).toString());
                output.append("\n");
                output.setCaretPosition(output.getDocument().getLength());
            }

        }
        //Search refrence menu item
        if (E.getSource() == search) {

            addJ.setVisible(false);
            addBo.setVisible(false);
            searchLbl.setVisible(true);
            outPanel.setBounds(10, 300, 370, 140);
            outPanel.setVisible(true);
            menuBox.setVisible(false);
            yearLbl.setVisible(false);
            year.setVisible(false);
            pubLbl.setVisible(false);
            pub.setVisible(false);
            titleLbl.setVisible(false);
            title.setVisible(false);
            auth.setVisible(false);
            authLbl.setVisible(false);
            call.setVisible(false);
            typeLbl.setVisible(false);
            typeChoose.setVisible(false);
            sResults.setVisible(true);
            messages.setVisible(false);
            callLbl.setVisible(true);
            call.setVisible(true);
            keyWLbl.setVisible(true);
            keyW.setVisible(true);
            orgLbl.setVisible(false);
            org.setVisible(false);
            sYearLbl.setVisible(true);
            sYear.setVisible(true);
            eYearLbl.setVisible(true);
            eYear.setVisible(true);
            searchB.setVisible(true);
            resetA.setVisible(false);
            resetS.setVisible(true);
            addB.setVisible(false);
            resetS.setVisible(true);

        }
        //Search button
        if (E.getSource() == searchB) {
            output.append("Searching..... \n");
            auth.setVisible(false);
            authLbl.setVisible(false);
            org.setVisible(false);
            orgLbl.setVisible(false);
            pub.setVisible(false);
            pubLbl.setVisible(false);
            addJ.setVisible(false);
            addBo.setVisible(false);
            String searchPart1 = call.getText();
            String searchPart2 = keyW.getText();
            //Local variables for the search
            int yStart = 1;
            int yEnd = 9999;
            int myYear = 0;
            int fFlag = 0;
            String found = "";
            //If item isnt a number, set the year to 1
            try {
                yStart = Integer.parseInt(sYear.getText());

                yEnd = Integer.parseInt(eYear.getText());
            } catch (NumberFormatException t) {
                yEnd = 1;
                yStart = 1;

            }
            //Set start and end year variables based on string
            String killMe = "NO";
            //Reset the found check
            String patternString;
            Pattern pattern;
            String SearchString = "(?i)";
            String[] titleSearch = searchPart2.split(" ");
            //Start RegEx compare string
            for (int searchCount = 0; searchCount < titleSearch.length; searchCount++) {
                SearchString = SearchString + ".*(.*\\b" + titleSearch[searchCount] + "\\b.*).*";

            }
            //Start the main search structure 
            for (int i = 0; i < rList.size(); i++) {
                patternString = (SearchString);
                pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(rList.get(i).getTitle());
                boolean matches = matcher.matches();

                int yTemp = yStart;
                if (matches == true) {
                    found = "Found";
                    killMe = "Yes";
                } else if (!searchPart2.equals("")) {
                    found = "NULL";
                }
                if (rList.get(i).getCallN().equalsIgnoreCase(searchPart1)) {
                    found = "Found";
                    killMe = "Yes";
                } else if (!searchPart1.equals("")) {
                    found = "NULL";
                }
                //Fix This....
                if (yStart == 1 && yEnd == 1) {
                } else {
                    myYear = Integer.parseInt(rList.get(i).getYear());
                    for (int l = yStart; l <= yEnd; l++) {
                        if (myYear == l) {
                            found = "Found";
                        } else {
                            found = "Nope";
                            killMe = "NO";
                        }
                    }
                }
                
                //Found output
                if ("Found".equals(found)) {
                    output.append("Found:");
                    output.append(rList.get(i).toString());
                    output.append("\n");
                    fFlag = 1;

                }

            }
            if (fFlag == 0) {
                output.append("Not Found \n");
            }
            call.setText("");
            auth.setText("");
            title.setText("");
            pub.setText("");
            year.setText("");
            eYear.setText("");
            sYear.setText("");
            keyW.setText("");
            org.setText("");
        }
        //Add buton on the frame
        if (E.getSource() == addB) {
            Refrence ent;
            switch (typeChoose.getSelectedItem().toString()) {
                case "Book":
                    ent = new Book();
                    ent.setType("Book");
                    if (call.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Call Number");
                        output.append("Failed Book addition \n");
                         break;
                    } else {
                        ent.setCallN(call.getText());
                    }
                    if (title.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Title");
                        output.append("Failed Book addition \n");
                         break;
                    } else {
                        ent.setTitle(title.getText());
                    }
                    if (auth.getText().equals("")) {
                        ent.setAuthor("N/A");
                    } else {
                        ent.setAuthor(auth.getText());
                    }
                    if (pub.getText().equals("")) {
                        ent.setPublish("N/A");
                    } else {
                        ent.setPublish(pub.getText());
                    }
                    if (year.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Year");
                        output.append("Failed Book addition \n");
                         break;
                    }
               try
                    {
                    if(Integer.parseInt(year.getText())>=1000&&Integer.parseInt(year.getText())<=9999)
                            {
                                 ent.setYear(year.getText());
                            }
                    
                    else
                    {
                            JOptionPane.showMessageDialog(frame, "You need to enter a Numerical Year (1000-9999)");
                    output.append("Failed Book addition \n");
                     break;
                            }
                    }
                catch(NumberFormatException t)
                {
                    JOptionPane.showMessageDialog(frame, "You need to enter a Numerical Year (1000-9999)");
                    output.append("Failed Book addition \n");
                     break;
                    
                    }
                    for (int i = 0; i < rList.size(); i++) {
                        if (rList.get(i).getYear().equalsIgnoreCase(year.getText()) && rList.get(i).getCallN().equals(call.getText())) {
                            dup++;
                        }
                    }
                    //Duplicate for callNumber and Year
                    if (dup >= 2) {
                        JOptionPane.showMessageDialog(frame, "You have a duplicate!");
                        output.append("Failed Book addition \n");
                        break;
                       
                        //If no problems, add to the arrayList
                    } else {
                        rList.add(ent);
                        output.append("Succesful Book addition \n");
                        call.setText("");
                        auth.setText("");
                        title.setText("");
                        pub.setText("");
                        year.setText("");
                        eYear.setText("");
                        sYear.setText("");
                        keyW.setText("");
                        org.setText("");
                    }
                    output.setCaretPosition(output.getDocument().getLength());
                    break;
                case "Journal":
                    ent = new Journal();
                    ent.setType("Journal");
                    if (call.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Call Number");
                        output.append("Failed Journal addition \n");
                         break;
                    } else {
                        ent.setCallN(call.getText());
                    }
                    if (title.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Title");
                        output.append("Failed Journal addition \n");
                         break;
                    } else {
                        ent.setTitle(title.getText());
                    }
                    if (org.getText().equals("")) {
                        ent.setOrg("N/A");
                    } else {
                        ent.setOrg(org.getText());
                    }

                    if (year.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "You need to enter a Year");
                        output.append("Failed Journal addition \n");
                         break;
                    } 
                    try
                    {
                    if(Integer.parseInt(year.getText())>1000&&Integer.parseInt(year.getText())<9999)
                            {
                                 ent.setYear(year.getText());
                            }
                    
                    else
                    {
                            JOptionPane.showMessageDialog(frame, "You need to enter a Numerical Year (1000-9999)");
                    output.append("Failed Journal addition \n");
                     break;
                            }
                    }
                catch(NumberFormatException t)
                {
                    JOptionPane.showMessageDialog(frame, "You need to enter a Numerical Year (1000-9999)");
                    output.append("Failed Journal addition \n");
                     break;
                    
                    }
                    for (int i = 0; i < rList.size(); i++) {
                        if (rList.get(i).getYear().equalsIgnoreCase(year.getText()) && rList.get(i).getCallN().equals(call.getText())) {
                            output.append(rList.get(i).getYear());
                            output.append(rList.get(i).getCallN());
                            dup++;
                        }
                    }
                    //Duplicate for callNumber and Year
                    if (dup >= 2) {
                        JOptionPane.showMessageDialog(frame, "You have a duplicate!");
                        output.append("Failed Journal addition \n");
                        //If no problems, add to the arrayList
                    } else {
                        rList.add(ent);
                        output.append("Succesful Journal addition \n");
                        call.setText("");
                        auth.setText("");
                        title.setText("");
                        pub.setText("");
                        year.setText("");
                        eYear.setText("");
                        sYear.setText("");
                        keyW.setText("");
                        org.setText("");
                    }
                    output.setCaretPosition(output.getDocument().getLength());
                    break;
            }
        }
        if (E.getSource() == sExit) {
            try {
                FileIO.PrintFile(rList, fpo);
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(AssignmentGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
        if (E.getSource() == exit) {
            System.exit(0);
        }
        validate();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        AssignmentGui aGui = new AssignmentGui();

    }
}
