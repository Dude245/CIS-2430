/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mChoice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nathan Reymer
 */
public class MChoice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        String[] questions = new String[400];
        String[] answers = new String[42];
        int filePointQ = 0;
        int filePointA = 0;
        String[] aSplit;
        int right = 0;
        int wrong = 0;
Scanner QR = new Scanner(MChoice.class.getResourceAsStream("\\files\\Q.txt"));
        //BufferedReader QR = new BufferedReader(new FileReader(qPath));
        while (QR.hasNext()) {
            questions[filePointQ] = QR.nextLine();
            filePointQ++;
        }

        filePointA = 0;
        Scanner AR = new Scanner(MChoice.class.getResourceAsStream("\\files\\A.txt"));
        System.out.println("Press any key to continue");
        List<Integer> dataList;
        dataList = new ArrayList<>();
        for (int i = 1; i < 41; i++) {
            dataList.add(i);
        }
        Collections.shuffle(dataList);
        int[] num = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            num[i] = dataList.get(i);
        }
          while (AR.hasNext()) {
            answers[filePointA] = AR.nextLine();
            filePointA++;
        }
        filePointA = 0;
        int myRand;
        Scanner in = new Scanner(System.in, "UTF-8");
        while (!"q".equals(in.nextLine())) {
            myRand = num[filePointA];
            int qRand = num[filePointA] * 6 - 6;
            System.out.println(questions[(qRand)]);
            System.out.println(questions[(qRand) + 1]);
            System.out.println(questions[(qRand) + 2]);
            System.out.println(questions[(qRand) + 3]);
            System.out.println(questions[(qRand) + 4]);
            System.out.println(questions[(qRand) + 5]);
            aSplit = answers[myRand - 1].split(" ");

            if (in.nextLine().equalsIgnoreCase(aSplit[1])) {
                System.out.println("Correct!");
                right++;
            } else {
                System.out.println("Incorrect");
                System.out.println("The correct answer is: " + aSplit[1]);
                wrong++;
            }
            if (filePointA == 39) {
                break;
            }
            filePointA++;
                       System.out.println("Press q to quit");
        }
        double score=(((double)right/(double)filePointA)*100);
        float myScore=Math.round(score);
        System.out.println("Right: " + right);
        System.out.println("Wrong: " + wrong);
        System.out.println("Score: " + myScore);
    }
}
