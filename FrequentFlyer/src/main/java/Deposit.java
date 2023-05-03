import java.util.Objects;
/**
 * Creates deposit for frequent flyer who wants to transfer miles to another account.
 * It requires amount to be deposited, recipient accountID and recipient name
 * @author Vrinda
 */

public class Deposit {
    private int depositAmount;
    private AccountID accountID;
    private Name name;

    /**
     * Creates deposit object and also checks if the deposited amount is in range 1000-10000
     * @param depositAmount amount to be deposited
     * @param accountID recipient AccountId
     * @param name recipient name
     */
    public Deposit(int depositAmount, AccountID accountID, Name name) {
        if(depositAmount < 1000 || depositAmount > 10000){
            throw new IllegalArgumentException("Deposit amount must be in range 1000-10000");
        }

        this.depositAmount = depositAmount;
        this.accountID = accountID;
        this.name = name;

    }

    /**
     * Returns recipient name
     * @return recipient name
     */

    public Name getName() {
        return this.name;
    }

    /**
     * returns amount to be deposited
     * @return amount to be deposited
     */
    public int getDepositAmount() {
        return depositAmount;
    }
    /**
     * returns recipient accID
     * @return recipient accID
     */
    public String getAccountID() {
        return accountID.getAccountID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit deposit)) return false;
        return getDepositAmount() == deposit.getDepositAmount() && getAccountID().equals(deposit.getAccountID()) &&
                getName().equals(deposit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepositAmount(), getAccountID(), getName());
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositAmount=" + depositAmount +
                ", accountID=" + accountID +
                ", name=" + name +
                '}';
    }
}
