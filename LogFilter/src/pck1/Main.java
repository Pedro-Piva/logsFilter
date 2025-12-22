package pck1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileRead fr = new FileRead();
        FileWrite fw = new FileWrite();
        CreateFile cf = new CreateFile();
        ReadInput ri = new ReadInput();
        
        
        Scanner sc = new Scanner(System.in);
        
        String path = ri.readInput(sc, "File Path");
        File file = new File(path);
        
        String day = ri.readInput(sc, "Day");
        String month = ri.readInput(sc, "Month");
        String hour = ri.readInput(sc, "Hour");
        
        sc.close();
        
        try {
            String fileContent = fr.readFile(file, day, month, hour);
            File filtered = cf.CreateFile(file.getName() + "Filter");
            if(filtered != null){
                fw.writeFile(filtered, fileContent);
                System.out.println("Logs Filtered with sucess");
            } else {
                System.out.println("ERROR");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex);
        }
    }
    
    

}
