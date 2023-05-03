import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
    Name name1;
    Name name2;
    @BeforeEach
    void setUp() {
        name1 = new Name("Will","Smith");
        name2 = new Name("Chandler","Bing","Muriel");
    }

    @Test
    void getFirstname() {
        assertEquals("Will",name1.getFirstname());
    }

    @Test
    void getLastname() {
        assertEquals("Smith",name1.getLastname());
    }

    @Test
    void getMiddlename() {
        assertEquals("Muriel",name2.getMiddlename());
        assertEquals(null,name1.getMiddlename());
    }

    @Test
    void testToString() {
        assertEquals("Will Smith",name1.toString());
        assertEquals("Chandler Bing Muriel",name2.toString());
    }

    @Test
    void firstNameException(){
        assertThrows(IllegalArgumentException.class, () -> new Name("","Smith"),
                "Please enter first name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name(" ","Smith"),
                "Please enter first name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name("","Smith","William"),
                "Please enter first name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name(" ","Smith","William"),
                "Please enter first name correctly!");

    }

    @Test
    void lastNameException(){
        assertThrows(IllegalArgumentException.class, () -> new Name("Will",""),
                "Please enter last name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name("Will"," "),
                "Please enter last name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name("Will","","William"),
                "Please enter last name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name("Will"," ","William"),
                "Please enter last name correctly!");

    }

    @Test
    void middleNameException(){

        assertThrows(IllegalArgumentException.class, () -> new Name("Will","Smith",""),
                "Please enter middle name correctly!");

        assertThrows(IllegalArgumentException.class, () -> new Name("Will","Smith"," "),
                "Please enter middle name correctly!");

    }

    @Test
    void testEquals_Name() {
        Name name = new Name("Chandler","Smith");
        assertTrue(name.equals(name));
    }
    @Test
    void testEquals_Null() {
        Name name = new Name("Chandler","Smith");
        assertFalse(name.equals(null));
    }

    @Test
    void testEquals_DifferentFirstName() {
        Name name2 = new Name("Chandler","Smith");
        assertFalse(name1.equals(name2));
    }

    @Test
    void testEquals_DifferentLastname() {
        Name name2 = new Name("Will","Bing");
        assertFalse(name1.equals(name2));
    }

    @Test
    void testEquals_DifferentMiddleName() {
        Name name = new Name("Chandler","Bing","Micheal");
        assertFalse(name.equals(name2));
    }

    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash("Will","Smith",null);
        System.out.println(name1);
        assertEquals(expectedHashCode,name1.hashCode());
    }

}