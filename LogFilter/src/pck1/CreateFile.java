package pck1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author pedro
 */
public class CreateFile {

    public File CreateFile(String fileName) {
        try {
            File myObj = new File(fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return myObj;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        return null;
    }
}
