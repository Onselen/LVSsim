public class IFF {
    /*
    IFF(Identidy Friend or Foe) class
    */

    // Attributes
    public boolean friend;
    public boolean foe;

    // Constructor
    public IFF() {}

    // Methods
    public void identify(String radarData){
        // Method that takes one line of raw radar data and outputs if the data is a friend or foe

        // Get entries of radar data
        String[] entries = radarData.split(";");

        // Identify if scan has detected a friend or foe
        int evenCount = 0;
        for (String entry : entries) {
            if (isEven(Integer.parseInt(entry))) {
                evenCount++;
            };
        }
        int unevenCount = entries.length - evenCount;

        // If there are more uneven than uneven entries in the data, the scan has detected a foe
        // Store result
        foe = unevenCount > evenCount;
        friend = !foe;

        // Print result
        if (foe) {
            System.out.println("System IFF has identified the object as FOE");
        } else {
            System.out.println("System IFF has identified the object as FRIEND");
        }
    }

    boolean isEven(int number){
        // Method that checks if number is even
        return (number%2 == 0);
    }
}