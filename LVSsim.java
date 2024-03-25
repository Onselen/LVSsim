import java.lang.Thread;

public class LVSsim {
    public static void main(String[] args){

        // This program will simulate three components:
        // - Radar
        // - Identification Friend or Foe (IFF
        // - Missile launcher
        //

        // Parameter settings
        int noScans = 20;                               // Amount of scans the simulation takes
        int scanRate = 1;                               // Rate [scan/second] at which the simulation will run
        long durationPerScan = 1000/scanRate;           // [miliseconds]
        String radarDataFilename = "radar_data.csv";    // Filename of file that contains the radardata

        // Option handling (not yet implemented)

        // Instantiate components of simulation
        Radar radar1 = new Radar(radarDataFilename);
        IFF iff1 = new IFF();
        Launcher launcher1 = new Launcher();

        // Simulation will start
        int i = 0;
        while (i < noScans) {
            // Scan for threats
            radar1.scanForThreats();

            // Identify friend or foe
            iff1.identify(radar1.lastScanResult);

            // Launch missile if foe is identified
            if (iff1.foe) {
                launcher1.launchMissile();
            }

            // Wait for the second to pass, before scanning another time (right now neglecting compute time)
            try{Thread.sleep(durationPerScan);} catch (Exception e) {}

            // Print empty line and increment i
            System.out.println();
            i++;
        }
    }
}