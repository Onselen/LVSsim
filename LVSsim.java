
public class LVSsim {
    public static void main(String[] args){

        // This program will simulate three components:
        // - Radar
        // - Identification Friend or Foe (IFF
        // - Missile launcher
        //
        // One unit can consist of one or more of these components
        // 

        // Parameter settings
        int noScans = 20;                             // Amount of scans the simulation takes
        long helpTime = 0;
        String radarDataFilename = "radar_data.csv";  // Filename of file that contains the radardata

        // Instantiate components of simulation
        Radar radar1 = new Radar(radarDataFilename);
        IFF iff1 = new IFF();
        Launcher launcher1 = new Launcher();

        // Simulation will start
        int i = 0;
        while (i < noScans) {
            helpTime = 0;

            // Scan for threats
            String radarData = radar1.scanForThreats();
            System.out.println("System radar has detected an object");

            // Identify friend or foe
            iff1.identify(radarData);

            // Launch missile if foe is identified
            boolean kill;
            if (iff1.foe) {
                System.out.println("System IFF has identified the object as foe");
                kill = launcher1.launchMissile();
                if (kill) {
                    System.out.println("System launcher has fired a missile and hit its target");
                } else {
                    System.out.println("System launcher has fired a missile and missed its target");
                }
            } else {
                System.out.println("System IFF has identified the object as friend");
            }
            System.out.println();
            i++;
        }
    }
}