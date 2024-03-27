import java.lang.Thread;
import java.util.ArrayList;

public class LVSsim {
    public static void main(String[] args){

        // This program will simulate one unit of a Luchtverdedigingssysteem (LVS)
        if (args.length < 5) {
            System.err.println("Please pass 5 arguments: [number or radars] [number or IFFs] [number or launchers] [number of scans] [radar data file]");
        }

        // Parameters & argument handling
        long durationPerScan = 1000;  // [miliseconds]
        int noRadars = Integer.valueOf(args[0]);
        int noIFFs = Integer.valueOf(args[1]);
        int noLaunchers = Integer.valueOf(args[2]);
        int noScans = Integer.valueOf(args[3]);         // Amount of scans the simulation takes
        String radarDataFilename = args[4];    // Filename of file that contains the radardata

        // Instantiate components of simulation
        ArrayList<Radar> radars = new ArrayList<Radar>();
        ArrayList<IFF> iffs = new ArrayList<IFF>();
        ArrayList<Launcher> launchers = new ArrayList<Launcher>();

        // Create objects
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
            for (Radar radar : radars) {
                radar.scanForThreats();
                
                for (IFF iff : iffs) {
                    System.out.print("\t");
                    iff.identify(radar.lastScanResult);

                    if (iff.foe) {
                        for (Launcher launcher : launchers) {
                            System.out.print("\t\t");
                            launcher.launchMissile();
                        }
                    }
                }
            }

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