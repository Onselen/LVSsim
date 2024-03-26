import java.util.ArrayList;
import java.util.Random;

public class Launcher {
    /*
    Launcher class
    */

    // Attributes
    public String name;
    double probabilityOfKill = 0.8;
    boolean available = true;
    Random random = new Random();
    ArrayList<Boolean> launches = new ArrayList<Boolean>();

    // Constructor
    public Launcher(String name){
        this.name = name;
    }

    // Methods
    boolean launchMissile(){
        if (available) {
            // Launch missile
            boolean kill = (random.nextDouble() < probabilityOfKill);

            // Store launch result
            this.launches.add(kill);

            // Print result
            if (kill) {
                System.out.println(name+" has fired a missile: HIT");
            } else {
                System.out.println(name+" has fired a missile: MISS");
            }

            available = false;

            return kill;
        } else {
            System.out.println(name+" is not available for missile launch");
            return false;
        }
    }
}