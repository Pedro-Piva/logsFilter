package pck1;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class ReadInput {
    public String readInput(Scanner sc, String objName){
        String res = "";
        do {
            try {
                System.out.print(objName + ": ");
                res = sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR:" + e);
            }
        } while(res.equals(""));
        return res;
    }
}
