package pck1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author pedro
 */
public class FileRead {

    public void readFile(File file, String startTime, String endTime, File filtered) throws FileNotFoundException {
        FileWrite fw = new FileWrite();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Running...");
            while (true) {
                line = br.readLine();
                String time = line.substring(0, 14);
                if (time.equals(startTime)) {
                    fw.writeFile(filtered, line + "\n");
                    while(true){
                        line = br.readLine();
                        time = line.substring(0, 14);
                        fw.writeFile(filtered, line + "\n");
                        if(time.equals(endTime)){
                            break;
                        }
                    }
                    break;
                } 
            }
        } catch (IOException e) {
            System.out.println("Error reading file." + e);
        }
    }
}
