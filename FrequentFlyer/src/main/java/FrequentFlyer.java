/**
 * Represents an FrequentFlyer with their details--accID, name, email and mile balance *
 * @author Vrinda
 *
 */
public class FrequentFlyer{
    private FrequentFlyerList flyerList = new FrequentFlyerList();

    private AccountID accID;
    private Name name;
    private String email;
    private MilesBalance balance;

    /**
     * Creates new Frequent flyer if they don't already exist given their accID, name, email and mile balance.
     * Once created adds them to the frequent flyer list.
     * @param accID flyer accID
     * @param name flyer name
     * @param email flyer email
     * @param balance flyer mile balance
     */
    public FrequentFlyer(AccountID accID, Name name, String email, MilesBalance balance) {
        if( !flyerList.contains(accID.getAccountID())) {
            this.accID = accID;
        }
        else{
            throw new IllegalArgumentException("Account Id already exists!");
        }
        this.name = name;
        this.email = email;
        this.balance = balance;
        flyerList.add(this);
    }

    /**
     * returns accID
     * @return flyer accID
     */
    public AccountID getAccID() {
        return accID;
    }
    /**
     * returns name
     * @return flyer name
     */
    public Name getName() {
        return name;
    }
    /**
     * returns email
     * @return flyer email
     */
    public String getEmail() {
        return email;
    }
    /**
     * returns mile balance
     * @return flyer mile balance
     */
    public MilesBalance getBalance() {
        return balance;
    }

    /**
     * allows a flyer to transfer miles from their account to someone else’s account
     * @param deposit have info of amount to be deposited, recipients accID and recipients name
     */
    public void transferMiles(Deposit deposit){
        if(flyerList.validateName(deposit.getAccountID(),deposit.getName())){
            if(this.balance.getTotalbalance() >= deposit.getDepositAmount()){
                flyerList.updateTotalMiles(this.getAccID().getAccountID(), -deposit.getDepositAmount());
                flyerList.updateExpireMiles(this.getAccID().getAccountID(), -deposit.getDepositAmount());

                flyerList.updateTotalMiles(deposit.getAccountID(), deposit.getDepositAmount());
                flyerList.updateExpireMiles(deposit.getAccountID(), deposit.getDepositAmount());
                flyerList.updateEarnedMiles(deposit.getAccountID(), deposit.getDepositAmount());
            }
            else {
                throw new IllegalArgumentException("Insufficient miles!");
            }
        }
        else {
            throw new IllegalArgumentException("Recipient does not exist.");
        }

    }


    @Override
    public String toString() {
        return "FrequentFlyer{" +
                "accID=" + accID +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }



}
