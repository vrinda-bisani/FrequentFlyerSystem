import java.util.Objects;
/**
 * Creates AccountID for frequent flyer by taking 12 char long input String
 * @author Vrinda
 */
public class AccountID {
    private final String accountID;

    /**
     * Creates accountID for frequent flyer. Also checks if the accountID is 12 char long.
     * @param accountID frequent flyer AccountID
     */
    public AccountID(String accountID) {
        if(accountID.length() == 12){
            this.accountID = accountID;
        }
        else {
            throw new IllegalArgumentException("AccountID must be 12 characters long");
        }
    }

    /**
     * Returns Frequent flyer AccountID
     * @return Frequent flyer AccountID
     */

    public String getAccountID() {
        return accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof AccountID accountID1)) {return false;}
        return getAccountID().equals(accountID1.getAccountID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountID());
    }

    @Override
    public String toString() {
        return "AccountID{" +
                "accountID='" + accountID + '\'' +
                '}';
    }
}
