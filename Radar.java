import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Radar {
    File radarDataFile;
    Scanner fileScanner;

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
        return fileScanner.nextLine();
    }
}
