import java.lang.Thread;
import java.util.ArrayList;

public class LVSsim {
    public static void main(String[] args){

        // This program will simulate one unit of a Luchtverdedigingssysteem (LVS)

        // Parameters
        int noScans = 20;                               // Amount of scans the simulation takes
        int scanRate = 1;                               // Rate [scan/second] at which the simulation will run
        long durationPerScan = 1000/scanRate;           // [miliseconds]
        String radarDataFilename = "radar_data.csv";    // Filename of file that contains the radardata

        // Option handling (not yet implemented)
        if (args.length < 3) {
            System.err.println("Please pass 3 arguments: [number or radars] [number or IFFs] [number or launchers]");
        }
        int noRadars = Integer.valueOf(args[0]);
        int noIFFs = Integer.valueOf(args[1]);
        int noLaunchers = Integer.valueOf(args[2]);

        // Instantiate components of simulation
        ArrayList<Radar> radars = new ArrayList<Radar>();
        ArrayList<IFF> iffs = new ArrayList<IFF>();
        ArrayList<Launcher> launchers = new ArrayList<Launcher>();

        // Create radars
        for (int i = 0; i < noRadars; i++) {
            radars.add(new Radar("Radar"+(i+1), radarDataFilename));
        }
        for (int i = 0; i < noIFFs; i++) {
            iffs.add(new IFF("IFF"+(i+1)));
        }
        for (int i = 0; i < noLaunchers; i++) {
            launchers.add(new Launcher("Launcher"+(i+1)));
        }

        // Simulation start
        int i = 0;
        while (i < noScans) {
            // Scan for threats
            for (Radar radar : radars) {
                radar.scanForThreats();
                
                // Identify friend or foe
                for (IFF iff : iffs) {
                    System.out.print("\t");
                    iff.identify(radar.lastScanResult);

                    // Launch missiles if foe is identified
                    if (iff.foe) {
                        for (Launcher launcher : launchers) {
                            System.out.print("\t\t");
                            launcher.launchMissile();
                        }
                    }
                }
            }

            // Print empty line and increment i
            System.out.println();
            i++;

            // Reload launchers
            for (Launcher launcher : launchers) {
                launcher.available = true;
            }

            // Wait for the second to pass, before scanning another time (right now neglecting compute time)
            if (i<noScans) {
                try{Thread.sleep(durationPerScan);} catch (Exception e) {}
            }
        }
    }
}