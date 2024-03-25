public class IFF {
    public boolean friend;
    public boolean foe;

    public IFF() {}

    public void identify(String radarData){
        // Get entries of radar data
        String[] entries = radarData.split(";");

        // Identify if scan has detected a friend or foe
        // If there are more uneven than uneven entries in the data, the scan has detected a foe
        int evenCount = 0;

        for (String entry : entries) {
            if (isEven(Integer.parseInt(entry))) {
                evenCount++;
            };
        }

        int unevenCount = entries.length - evenCount;

        foe = unevenCount > evenCount;
        friend = !foe;
        if (foe) {
            System.out.println("System IFF has identified the object as FOE");
        } else {
            System.out.println("System IFF has identified the object as FRIEND");
        }
    }

    boolean isEven(int number){
        return (number%2 == 0);
    }
    
}
