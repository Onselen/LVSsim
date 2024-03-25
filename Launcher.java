import java.util.ArrayList;
import java.util.Random;

public class Launcher {
    /*
    Launcher class
    */

    // Attributes
    double probabilityOfKill = 0.8;
    Random random = new Random();
    ArrayList<Boolean> launches = new ArrayList<Boolean>();

    // Constructor
    public Launcher(){}

    // Methods
    boolean launchMissile(){
        // Launch missile
        boolean kill = (random.nextDouble() < probabilityOfKill);

        // Store launch result
        this.launches.add(kill);

        // Print result
        if (kill) {
            System.out.println("System launcher has fired a missile: HIT");
        } else {
            System.out.println("System launcher has fired a missile: MISS");
        }

        return kill;
    }

}
