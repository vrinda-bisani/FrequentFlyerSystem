import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DepositTest {
    Deposit deposit;

    static AccountID sender_accountID;
    static Name sender_name;
    static MilesBalance sender_milesbalance;
    static FrequentFlyer sender_ff;

    static AccountID recepient_AccountID;
    static Name recepient_name;
    static MilesBalance recepient_milesbalance;
    static FrequentFlyer recepient_ff;

    @BeforeAll
    static void setUp() {

        sender_accountID = new AccountID("123456123499");
        sender_name = new Name("Vrinda","Bisani");
        sender_milesbalance = new MilesBalance(6000,500,300);
        sender_ff = new FrequentFlyer(
                sender_accountID,
                sender_name,
                "vrindabisani@gmail.com",
                sender_milesbalance);

        recepient_AccountID = new AccountID("123456123498");
        recepient_name = new Name("Nikhil","Chandak");
        recepient_milesbalance = new MilesBalance(3000,100,100);
        recepient_ff = new FrequentFlyer(
                recepient_AccountID,
                recepient_name,
                "nc@gmail.com",
                recepient_milesbalance);
    }

    @Test
    void getName() {
        deposit = new Deposit(1600, recepient_AccountID,recepient_name);
        assertEquals(recepient_name , deposit.getName());
    }

    @Test
    void getDepositAmount() {
        deposit = new Deposit(1600, recepient_AccountID,recepient_name);
        assertEquals(1600 , deposit.getDepositAmount());
    }

    @Test
    void getAccountID() {
        deposit = new Deposit(1600, recepient_AccountID,recepient_name);
        assertEquals( recepient_AccountID.getAccountID(), deposit.getAccountID());
    }

    @Test
    void testToString() {
        deposit = new Deposit(1600, recepient_AccountID,recepient_name);
        assertEquals("Deposit{" +
                "depositAmount=" + 1600 +
                ", accountID=" +  recepient_AccountID+
                ", name=" + recepient_name  +
                '}',deposit.toString());
    }

    @Test
    void depositAmountException(){
        assertThrows(IllegalArgumentException.class, () -> new Deposit(900, recepient_AccountID,recepient_name),
                "Deposit amount must be in range 1000-10000");
        assertThrows(IllegalArgumentException.class, () -> new Deposit(100000, recepient_AccountID,recepient_name),
                "Deposit amount must be in range 1000-10000");
    }

    @Test
    void testHashCode() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        Deposit deposit2 = new Deposit(1500,sender_accountID,sender_name);
        assertEquals(deposit.hashCode(),deposit2.hashCode());
    }


    @Test
    void testEquals_SameObject() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        assertTrue(deposit.equals(deposit));
    }

    @Test
    void testEquals_DifferentDatatype(){
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        String test = "test";
        assertFalse(deposit.equals(test));
    }

    @Test
    void testEquals_DifferentObject() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        Deposit deposit1 = new Deposit(1500,sender_accountID,sender_name);
        assertTrue(deposit.equals(deposit1));
    }

    @Test
    void testEquals_Null() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        assertFalse(deposit.equals(null));
    }

    @Test
    void testEquals_DifferentAmount() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        Deposit deposit1 = new Deposit(1600,sender_accountID,sender_name);
        assertFalse(deposit.equals(deposit1));
    }

    @Test
    void testEquals_DifferentAccID() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        Deposit deposit1 = new Deposit(1500,recepient_AccountID,sender_name);
        assertFalse(deposit.equals(deposit1));
    }

    @Test
    void testEquals_DifferentName() {
        Deposit deposit = new Deposit(1500,sender_accountID,sender_name);
        Deposit deposit1 = new Deposit(1500,sender_accountID,recepient_name);
        assertFalse(deposit.equals(deposit1));
    }

}