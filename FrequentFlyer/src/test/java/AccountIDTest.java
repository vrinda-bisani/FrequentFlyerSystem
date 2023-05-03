import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class AccountIDTest {

    AccountID testAccID = new AccountID("123456123456");


    @Test
    void getAccountID() {
        assertEquals("123456123456" , testAccID.getAccountID());
        assertThrows(IllegalArgumentException.class, () -> new AccountID("1234561234"),
                "AccountID must be 12 characters long");
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testAccID.equals(testAccID));
    }

    @Test
    void testEquals_Null() {
        assertFalse(testAccID.equals(null));
    }

    @Test
    void testEquals_DifferentDatatype() {
        String test = "test";
        assertFalse(testAccID.equals(test));
    }

    @Test
    void testEquals_DifferentObject() {
        AccountID testAccID2 = new AccountID("123456123456");
        assertTrue(testAccID.equals(testAccID2));
    }


    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash("123456123456");
        assertEquals(expectedHashCode,testAccID.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("AccountID{accountID='123456123456" + '\'' + '}',testAccID.toString());
    }


}