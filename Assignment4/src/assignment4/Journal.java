package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Journal extends Refrence {

     public Refrence jAdd(ArrayList<Refrence> rList) {
        int dup = 0;
        Refrence ent = new Journal();
        Scanner in = new Scanner(System.in, "UTF-8");
        ent.setType("Journal");
        System.out.print("What is the Call Number?: ");
        input = in.nextLine().trim();
        ent.setCallN(input);
        if ("".equals(input)) {
            while ("".equals(input)) {
                System.out.println("You need to enter a Call Number");
                input = in.nextLine().trim();
            }
        }
        //Duplication Check 1
        for (int i = 0; i < rList.size(); i++) {
            if (rList.get(i).getCallN().equalsIgnoreCase(input)) {
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
        ent.setTitle(input);
        System.out.print("What orginization?: ");
        input = in.nextLine().trim();
        if (input.equals("")) {
            input = "N/A";
        }
        ent.setOrg(input);
        System.out.print("What is the year of Publication?: ");
        input = in.nextLine().trim();
        if ("".equals(input)) {
            while ("".equals(input)) {
                System.out.println("You need to enter a Year");
                input = in.nextLine().trim();
            }
        }
        ent.setYear(input);
        //Duplication check 2
        for (int i = 0; i < rList.size(); i++) {
            if (rList.get(i).getYear().equalsIgnoreCase(input)) {
                dup++;
            }
        }
        //Duplication kill
        if (dup == 2) {
            System.out.println();
            System.out.println("Seems like you have a duplicate! \n");
            //Add to arrayList
        } else {
            rList.add(ent);
        }
        return ent;
    }

}
