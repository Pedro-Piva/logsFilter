package pck1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        FileRead fr = new FileRead();
        CreateFile cf = new CreateFile();
        ReadInput ri = new ReadInput();
        Scanner sc = new Scanner(System.in);
        String path = ri.readInput(sc, "File Path");
        File file = new File(path);
        
        String startTime = ri.readInput(sc, "Start Time");
        String endTime = ri.readInput(sc, "End Time");
        //String day = ri.readInput("Day");
        //String month = ri.readInput("Month");
        //String hour = ri.readInput("Hour");

        System.out.println("Started at: " + start);

        try {
            File filtered = cf.CreateFile(file.getName() + "Filter");
            fr.readFile(file, startTime, endTime, filtered);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex);
        }
        Instant end = Instant.now();
        System.out.println("Ended in = " + end);
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("TIme elapsed = " + timeElapsed / 60);
    }

}
