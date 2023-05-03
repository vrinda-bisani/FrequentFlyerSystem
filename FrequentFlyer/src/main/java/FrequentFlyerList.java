import java.util.HashMap;
/**
 * Maintains list of all frequent flyer and performs some task like validating frequent flyer, updating total/earned/expiring miles
 * @author Vrinda
 */
public class FrequentFlyerList {
    private static HashMap<String,FrequentFlyer> flyerList = new HashMap<>();

    /**
     * Adds new frequent flyer to flyer list
     * @param ff Frequent flyer object
     */
    public void add(FrequentFlyer ff) {
        this.flyerList.put(ff.getAccID().getAccountID(), ff);
    }

    /**
     * Checks if frequent flyer Account is already created
     * @param accID frequent flyer accID
     * @return True if flyer is present else returns false
     */
    public boolean contains(String accID){
        return flyerList.containsKey(accID);
    }

    /**
     * Checks that the provided ID matches recipient’s name.
     * @param accID recipient accID
     * @param name recipient name
     * @return true if ID matches recipient’s name else returns false
     */
    public boolean validateName(String accID, Name name){
         if(flyerList.get(accID) != null){
             if(flyerList.get(accID).getName().equals(name)){
                     return true;
             }
             return false;
         }
         return false;
    }

    /**
     * Updates totalMiles
     * @param accID flyer AccID whose total miles is to be updated
     * @param miles miles to be updated
     */
    public void updateTotalMiles(String accID, int miles){
        int newBalance = flyerList.get(accID).getBalance().getTotalbalance() + miles;
        FrequentFlyer ff = flyerList.get(accID);
        ff.getBalance().setTotalbalance(newBalance);
        flyerList.put(accID,ff);
    }

    /**
     * Updates Earned Miles
     * @param accID flyer AccID whose earned miles is to be updated
     * @param miles miles to be updated
     */
    public void updateEarnedMiles(String accID, int miles){
        int newBalance = flyerList.get(accID).getBalance().getMilesEarned() + miles;
        FrequentFlyer ff = flyerList.get(accID);
        ff.getBalance().setMilesEarned(newBalance);
        flyerList.put(accID,ff);
    }

    /**
     * Updates Expired Miles
     * @param accID flyer AccID whose expire miles is to be updated
     * @param miles miles to be updated
     */
    public void updateExpireMiles(String accID, int miles){
        int newBalance = flyerList.get(accID).getBalance().getMilesExpire() + miles;
        FrequentFlyer ff = flyerList.get(accID);
        if(newBalance < 0){
            newBalance = 0;
        }
        ff.getBalance().setMilesExpire(newBalance);
        flyerList.put(accID,ff);
    }

}
