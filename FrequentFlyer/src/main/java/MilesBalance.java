import java.util.Objects;
/**
 * Record representing total miles available, miles earned this year and miles expiring by the end of this calendar year
 * @author Vrinda
 */
public class MilesBalance {
    //Assuming miles earned is valid for 1 year
    private int totalbalance;
    private int milesEarned;
    private int milesExpire;

    /**
     * Record representing total miles available, miles earned this year and miles expiring by the end of this calendar year
     * @param totalbalance total miles available
     * @param milesEarned miles earned this year
     * @param milesExpire miles expiring by the end of this calendar year
     */
    public MilesBalance(int totalbalance, int milesEarned, int milesExpire) {
        this.totalbalance = totalbalance;
        this.milesEarned = milesEarned;
        this.milesExpire = milesExpire;
    }

    /**
     * get total mile balance
     * @return total mile balance
     */
    public int getTotalbalance() {
        return totalbalance;
    }

    /**
     * get earned mile balance
     * @return earned mile balance
     */
    public int getMilesEarned() {
        return milesEarned;
    }

    /**
     * get expiring mile balance
     * @return expiring mile balance
     */
    public int getMilesExpire() {
        return milesExpire;
    }

    /**
     * Set Miles earned
     * @param milesEarned miles earned
     */

    public void setMilesEarned(int milesEarned) {
        this.milesEarned = milesEarned;
    }

    /**
     * Set Miles expire
     * @param milesExpire miles expire
     */

    public void setMilesExpire(int milesExpire) {
        this.milesExpire = milesExpire;
    }
    /**
     * Set Miles total miles
     * @param totalbalance total miles
     */

    public void setTotalbalance(int totalbalance) {
        this.totalbalance = totalbalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilesBalance that)) return false;
        return getTotalbalance() == that.getTotalbalance() && getMilesEarned() == that.getMilesEarned() && getMilesExpire() == that.getMilesExpire();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalbalance(), getMilesEarned(), getMilesExpire());
    }

    @Override
    public String toString() {
        return "MilesBalance{" +
                "totalbalance=" + totalbalance +
                ", milesEarned=" + milesEarned +
                ", milesExpire=" + milesExpire +
                '}';
    }
}
