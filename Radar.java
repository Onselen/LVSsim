import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Radar {
    File radarDataFile;
    Scanner fileScanner;
    String lastScanResult;

    public Radar(String passedRadarDataFilename) {
        radarDataFile = new File(passedRadarDataFilename);
        try{
            fileScanner = new Scanner(radarDataFile);}
        catch (FileNotFoundException e){
            System.err.println("Radar data file not found");
        }
    }

    String scanForThreats() {
        System.out.println("System radar has detected an object");
        this.lastScanResult = fileScanner.nextLine();
        return this.lastScanResult;
    }
}
