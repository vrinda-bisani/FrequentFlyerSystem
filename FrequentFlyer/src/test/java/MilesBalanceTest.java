import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MilesBalanceTest {
    MilesBalance milesbalance;
    @BeforeEach
    void setUp() {
        milesbalance = new MilesBalance(3000,300,100);
    }

    @Test
    void getTotalbalance() {
        assertEquals(3000,milesbalance.getTotalbalance());
    }


    @Test
    void getMilesEarned() {
        assertEquals(300,milesbalance.getMilesEarned());
    }

    @Test
    void getMilesExpire() {
        assertEquals(100,milesbalance.getMilesExpire());
    }

    @Test
    void setMilesEarned() {
        milesbalance.setMilesEarned(400);
        assertEquals(400,milesbalance.getMilesEarned());
    }

    @Test
    void setMilesExpire() {
        milesbalance.setMilesExpire(300);
        assertEquals(300,milesbalance.getMilesExpire());
    }

    @Test
    void setTotalbalance() {
        milesbalance.setTotalbalance(2000);
        assertEquals(2000,milesbalance.getTotalbalance());
    }

    @Test
    void testToString() {
        assertEquals("MilesBalance{" +
                "totalbalance=" + milesbalance.getTotalbalance() +
                ", milesEarned=" + milesbalance.getMilesEarned() +
                ", milesExpire=" + milesbalance.getMilesExpire() +
                '}', milesbalance.toString());
    }

    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash(3000,300,100);
        assertEquals(expectedHashCode,milesbalance.hashCode());
    }


    @Test
    void testEquals_SameObject() {
        assertTrue(milesbalance.equals(milesbalance));
    }

    @Test
    void testEquals_DifferentDatatype(){
        String test = "test";
        assertFalse(milesbalance.equals(test));
    }

    @Test
    void testEquals_DifferentObject() {
        MilesBalance milesBalance2 = new MilesBalance(3000,300,100);
        assertTrue(milesbalance.equals(milesBalance2));
    }

    @Test
    void testEquals_Null() {
        assertFalse(milesbalance.equals(null));
    }

    @Test
    void testEquals_DifferentTotalBalance() {
        MilesBalance milesBalance2 = new MilesBalance(4000,300,100);
        assertFalse(milesbalance.equals(milesBalance2));
    }

    @Test
    void testEquals_DifferentMilesEarned() {
        MilesBalance milesBalance2 = new MilesBalance(3000,100,100);
        assertFalse(milesbalance.equals(milesBalance2));
    }

    @Test
    void testEquals_DifferentName() {
        MilesBalance milesBalance2 = new MilesBalance(3000,300,300);
        assertFalse(milesbalance.equals(milesBalance2));
    }

}