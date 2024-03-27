public class IFF {
    /*
    IFF(Identidy Friend or Foe) class
    */

    // Attributes
    public String name;
    public boolean friend;
    public boolean foe;

    // Constructor
    public IFF(String name) {
        this.name = name;
    }

    // Methods
    public void identify(String radarData){
        // Method that takes one line of raw radar data and outputs if the data is a friend or foe

        String[] entries = radarData.split(";");

        int evenCount = 0;
        for (String entry : entries) {
            if (isEven(Integer.parseInt(entry))) {
                evenCount++;
            };
        }
        int unevenCount = entries.length - evenCount;

        // If there are more uneven than uneven entries in the data, the scan has detected a foe
        foe = unevenCount > evenCount;
        friend = !foe;

        if (foe) {
            System.out.println(name+" has identified the object as FOE");
        } else {
            System.out.println(name+" has identified the object as FRIEND");
        }
    }

    boolean isEven(int number){
        return (number%2 == 0);
    }
}