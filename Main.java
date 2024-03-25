
public class Main {
    public static void main(String[] args){

        // This program will simulate three components:
        // - Radar
        // - Identification Friend or Foe (IFF
        // - Missile launcher
        //
        // One unit can consist of one or more of these components
        // 

        // Parameter settings
        String radarDataFilename = "radar_data.csv";  // Filename of file that contains the radardata

        // Instantiate components of simulation
        Radar radar1 = new Radar(radarDataFilename);
        IFF iff1 = new IFF();
    }
}