import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FrequentFlyerTest {
    Deposit deposit;

    static AccountID sender_accountID = new AccountID("123456123457");
    static Name sender_name = new Name("Will","Smith");
    static MilesBalance sender_milesbalance = new MilesBalance(6000,500,300);
    static FrequentFlyer sender_ff ;

    static AccountID recepient_AccountID= new AccountID("123456123456");
    static Name recepient_name= new Name("Chandler","Bing");
    static MilesBalance recepient_milesbalance = new MilesBalance(3000,100,100);
    static FrequentFlyer recepient_ff ;

    @BeforeAll
    static void setUp() {
        sender_ff = new FrequentFlyer(
                sender_accountID,
                sender_name,
                "ws@gmail.com",
                sender_milesbalance);

        recepient_ff = new FrequentFlyer(
                recepient_AccountID,
                recepient_name,
                "cb@gmail.com",
                recepient_milesbalance);

    }

    @Test
    void getAccID() {
        assertEquals( sender_accountID, sender_ff.getAccID());
    }

    @Test
    void getName() {
        assertEquals( sender_name, sender_ff.getName());
    }

    @Test
    void getEmail() {
        assertEquals( "ws@gmail.com", sender_ff.getEmail());
    }

    @Test
    void getBalance() {
        assertEquals(sender_milesbalance , sender_ff.getBalance());
    }

    @Test
    void accIDAlreadyExistException(){
        assertThrows(IllegalArgumentException.class, () -> new FrequentFlyer(sender_accountID,sender_name,"abc@gmail.com",sender_milesbalance),
                "Account Id already exists!");
    }
    @Test
    void transferMiles() {
        deposit = new Deposit(4000,recepient_AccountID,recepient_name);
        sender_ff.transferMiles(deposit);

        //For sender: Expire = 0, Totalmiles -= 4000 = 2000, earned = 500
        assertEquals(2000,sender_ff.getBalance().getTotalbalance());
        assertEquals(500,sender_ff.getBalance().getMilesEarned());
        assertEquals(0,sender_ff.getBalance().getMilesExpire());

        //For receipient : Expire = 100+4000 = 4100, Totalmiles += 4000 = 7000, earned = 100+4000 = 4100
        assertEquals(7000,recepient_ff.getBalance().getTotalbalance());
        assertEquals(4100,recepient_ff.getBalance().getMilesEarned());
        assertEquals(4100,recepient_ff.getBalance().getMilesExpire());
    }
    @Test
    void insufficientMiles() {
        deposit = new Deposit(7000,sender_accountID,sender_name);
        assertThrows(IllegalArgumentException.class, () -> sender_ff.transferMiles(deposit),
                "Insufficient miles!");
    }

    @Test
    void validateUserException(){
        // AccountId does not exist
        deposit = new Deposit(7000,new AccountID("123456123454"),sender_name);
        assertThrows(IllegalArgumentException.class, () -> sender_ff.transferMiles(deposit),
                "Recipient does not exist.");

        //name associated with the AccountId is not same
        deposit = new Deposit(7000,sender_accountID,new Name("Monica","Geller"));
        assertThrows(IllegalArgumentException.class, () -> sender_ff.transferMiles(deposit),
                "Recipient does not exist.");

    }

    @Test
    void testToString() {
        assertEquals("FrequentFlyer{" +
                "accID=" + sender_accountID +
                ", name=" + sender_name +
                ", email='" + "ws@gmail.com" + '\'' +
                ", balance=" + sender_milesbalance +
                '}', sender_ff.toString());
    }
}