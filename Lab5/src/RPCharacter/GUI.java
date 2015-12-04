/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCharacter;

import static RPCharacter.RPCharacterManager.CHARACTER_FILE_PATH;
import static RPCharacter.RPCharacterManager.characterList;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Die;
import utils.FileIO;

/**
 *
 * @author Nathan
 */
public class GUI extends JFrame implements ActionListener {

    public static ArrayList<RPCharacter> characterList = new ArrayList<>();
    static String CHARACTER_FILE_PATH = "./data/rpdata.save";
    ArrayList<HashMap<String, String>> characterHashList;

    private JMenuItem create = new JMenuItem("Create");
    private JMenuItem edit = new JMenuItem("Edit");
    private JMenuItem enc = new JMenuItem("Enhance");
    private JMenuItem exit = new JMenuItem("Exit");
    private JButton nextChar = new JButton("Next Character");
    private JButton accept = new JButton("Accept");
    private JButton cancel = new JButton("Cancel");
    int currentC = 0;
    boolean clicked = false;
    boolean editable = false;
    boolean createAble = false;

    JFrame frame = new JFrame("RPCharacter Manager");
    JLabel fNameLabel = new JLabel("First Name");
    JTextField fName = new JTextField();
    JLabel lNameLabel = new JLabel("Last Name");
    JTextField lName = new JTextField();
    JLabel ageLabel = new JLabel("Age");
    JTextField age = new JTextField();
    JLabel classLabel = new JLabel("Class");
    JTextField cClass = new JTextField();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    String Classes[] = {"Wizard", "Bard", "Fighter"};
    JComboBox classChoose = new JComboBox(Classes);
    int cFlag = 0;

    public GUI() throws InterruptedException {
        characterHashList = FileIO.readDataFromFile(CHARACTER_FILE_PATH);
        characterList = RPCharacter.convertHashMapListToCharacterList(characterHashList);
        revalidate();
        repaint();
        //Create the menu bar.

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        create.addActionListener(this);
        edit.addActionListener(this);
        exit.addActionListener(this);
        enc.addActionListener(this);
        nextChar.addActionListener(this);
        accept.addActionListener(this);
        cancel.addActionListener(this);
        classChoose.addActionListener(this);

        classChoose.setSelectedIndex(0);

        frame.setLayout(null);
        menu.add(create);
        menu.add(edit);
        menu.add(enc);
        menu.add(exit);
        frame.setBackground(Color.white);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nextChar.setBounds(200, 350, 120, 40);
        accept.setBounds(80, 350, 120, 40);
        accept.setVisible(false);
        cancel.setVisible(false);
        cancel.setBounds(220, 350, 120, 40);
        frame.add(accept);
        frame.add(cancel);
        frame.add(nextChar);

        frame.setVisible(true);
        fNameLabel.setBounds(20, 20, 100, 40);
        fName.setBounds(120, 20, 100, 40);
        lNameLabel.setBounds(20, 80, 100, 40);
        lName.setBounds(120, 80, 100, 40);
        ageLabel.setBounds(20, 110, 100, 100);
        age.setBounds(120, 140, 100, 40);
        classLabel.setBounds(20, 170, 100, 100);
        cClass.setBounds(121, 200, 100, 40);
        classChoose.setBounds(120, 200, 100, 40);
        frame.add(fNameLabel);

        frame.add(fNameLabel);
        fName.setEditable(editable);
        frame.add(fName);

        frame.add(lNameLabel);
        lName.setEditable(editable);
        frame.add(lName);

        frame.add(ageLabel);
        age.setEditable(editable);
        frame.add(age);

        frame.add(classLabel);
        frame.add(classChoose);
        frame.add(cClass);
        cClass.setEditable(editable);
        cClass.setVisible(true);
        classChoose.setVisible(false);

        revalidate();
        repaint();

    }

    public static void main(String args[]) throws InterruptedException {
        new GUI();

    }

    @Override
    public void actionPerformed(ActionEvent E) {
        if (E.getSource() == exit) {
          FileIO.printMe(RPCharacter.convertCharacterListToHashMapList(characterList), CHARACTER_FILE_PATH);
            System.exit(0);
        } else if (E.getSource() == edit) {
            nextChar.setVisible(false);
            accept.setVisible(true);
            cancel.setVisible(true);
            classChoose.setVisible(true);
            cClass.setVisible(false);
            editable = true;
            clicked = true;
            fName.setEditable(editable);
            lName.setEditable(editable);
            age.setEditable(editable);
            editable = false;
        } else if (E.getSource() == accept) {
            fName.getText();
            lName.getText();
            classChoose.getEditor().getItem();
            age.getText();
            if (cFlag == 0) {
                //Add things
            }
            if (cFlag == 1) {
                Die test = new Die();
                FileIO FileIO = new FileIO();
                int rollMe;
                RPCharacter newCharacter;
                String tempClass = String.valueOf(classChoose.getEditor().getItem());
                System.out.println("Class: " + tempClass);
                newCharacter = new RPWizard("WIZARD");
//                if (tempClass.equals("Fighter")) {
//                    newCharacter = new RPFighter("FIGHTER");
//                } else if (tempClass.equals("Wizard")) {
//                    newCharacter = new RPWizard("WIZARD");
//
//                } else {
//                    newCharacter = new RPBard("BARD");

                newCharacter.setFirstName(fName.getText());
                newCharacter.setLastName(lName.getText());
                newCharacter.setAge(Integer.parseInt(age.getText()));
                characterList.add(newCharacter);
                currentC = characterList.size() - 1;
                rollMe = test.generateAbilityScoreStandard();
                characterList.get(currentC).setCharisma(rollMe);
                rollMe = test.generateAbilityScoreStandard();
                characterList.get(currentC).setIntelligence(rollMe);
                rollMe = test.generateAbilityScoreStandard();
                characterList.get(currentC).setWisdom(rollMe);
                rollMe = test.generateAbilityScoreStandard();
                characterList.get(currentC).setDexterity(rollMe);
                characterList.get(currentC).setConstitution(rollMe);
                rollMe = test.generateAbilityScoreStandard();
                characterList.get(currentC).setStrength(rollMe);
                nextChar.setVisible(true);
                accept.setVisible(false);
                cancel.setVisible(false);
            }
        } else if (E.getSource() == cancel) {
            accept.setVisible(false);
            cancel.setVisible(false);
            nextChar.setVisible(true);
            editable = false;
            fName.setEditable(editable);
            lName.setEditable(editable);
            age.setEditable(editable);
            cClass.setEditable(editable);
            cClass.setVisible(true);
            classChoose.setVisible(false);

        } else if (E.getSource() == create) {
            createAble = true;
            cClass.setVisible(false);
            nextChar.setVisible(false);
            classChoose.setVisible(true);
            accept.setVisible(true);
            cancel.setVisible(true);
            editable = true;
            fName.setEditable(editable);
            lName.setEditable(editable);
            age.setEditable(editable);
            fName.setText("Enter First Name");
            lName.setText("Enter Last Name");
            age.setText("Enter Age");
            cClass.setText("Enter Class");
            cFlag = 1;

        } else if (E.getSource() == nextChar) {
            nextChar.setVisible(true);
            cClass.setVisible(true);
            cClass.setEditable(false);

            fName.setText(characterList.get(currentC).getFirstName());
            lName.setText(characterList.get(currentC).getLastName());
            cClass.setText(characterList.get(currentC).getCharacterClass());
            age.setText(String.valueOf(characterList.get(currentC).getAge()));
            if (characterList.size() - 1 <= currentC) {
                currentC = 0;

            } else if (currentC < characterList.size()) {
                currentC++;
                editable = false;
            }
        }

    }
    
}
