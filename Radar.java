import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Radar {
    /*
    Radar class
    Constructed with a particular radar data file
    */

    // Attributes
    File radarDataFile;
    Scanner fileScanner;
    String lastScanResult;
    ArrayList<String> scans = new ArrayList<String>();

    // Constructor
    public Radar(String passedRadarDataFilename) {
        radarDataFile = new File(passedRadarDataFilename);
        try{
            fileScanner = new Scanner(radarDataFile);}
        catch (FileNotFoundException e){
            System.err.println("Radar data file not found");
        }
    }

    // Methods
    String scanForThreats() {
        // Method for scanning threats based on the given datafile
        String result = fileScanner.nextLine();

        // Store scan result
        this.lastScanResult = result;
        this.scans.add(result);

        // Print result
        System.out.println("System radar has detected an object");

        return this.lastScanResult;
    }
}
