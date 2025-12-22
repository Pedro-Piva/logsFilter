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

    public String readFile(File file, String day, String month, String hour) throws FileNotFoundException {
        String res = "";
        String stop = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String fMonth = line.substring(0, 1);
                String fDay = line.substring(3, 4);
                String fHour = line.substring(6, 7);
                String added = "";
                if (fMonth.equals(month) && fDay.equals(day) && checkHour(Integer.parseInt(fHour), Integer.parseInt(hour))) {
                    res += line;
                    res += "\n";
                    added = line;
                } 
                if(!line.equals(added) && !res.equals("")){
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        if (res.equals("")) {
            return null;
        }
        return res;
    }

    protected boolean checkHour(int fH, int h) {
        return (fH == h || fH == h + 1 || fH == h - 1);
    }
}
