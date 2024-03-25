import java.util.ArrayList;
import java.util.Random;

public class Launcher {
    double probabilityOfKill = 0.8;
    Random random = new Random();
    ArrayList<Boolean> launches = new ArrayList<Boolean>();

    public Launcher(){}

    boolean launchMissile(){
        boolean kill = (random.nextDouble() < probabilityOfKill);
        this.launches.add(kill);

        if (kill) {
            System.out.println("System launcher has fired a missile: HIT");
        } else {
            System.out.println("System launcher has fired a missile: MISS");
        }

        return kill;
    }

}
