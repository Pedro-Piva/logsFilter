package pck1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pedro
 */
public class FileWrite {

    public void writeFile(File file, String content) {
        try (FileWriter myWriter = new FileWriter(file, true)) {
            myWriter.write(content);
            //System.out.println("Successfully writed to the file.");
        } catch (IOException e) {
            System.out.println("ERROR WRITING: " + e);
        }
    }
}
