import java.util.Objects;
/**
 * Represents frequent flyer name details-- firstname, lastname, middlename
 * @author Vrinda
 */
public class Name {
    private String firstname;
    private String lastname;
    private String middlename;

    /**
     * Represents frequent flyer name and also checks if input is not empty or blank
     * @param firstname first name
     * @param lastname last name
     */
    public Name(String firstname, String lastname) {
        if(!firstname.isEmpty() && !firstname.isBlank()){this.firstname = firstname;}
        else{throw new IllegalArgumentException("Please enter first name correctly!");}

        if(!lastname.isEmpty() && !lastname.isBlank() ){this.lastname = lastname;}
        else{throw new IllegalArgumentException("Please enter last name correctly!");}
    }

    /**
     * Represents frequent flyer name and also checks if input is not empty or blank
     * @param firstname first name
     * @param lastname last name
     * @param middlename middle name
     */
    public Name(String firstname, String lastname, String middlename) {
        if(!firstname.isEmpty() && !firstname.isBlank() ){this.firstname = firstname;}
        else{throw new IllegalArgumentException("Please enter first name correctly!");}

        if(!lastname.isEmpty() && !lastname.isBlank()){this.lastname = lastname;}
        else{throw new IllegalArgumentException("Please enter last name correctly!");}

        if(!middlename.isEmpty() && !middlename.isBlank()){this.middlename = middlename;}
        else{throw new IllegalArgumentException("Please enter middle name correctly!");}

    }

    /**
     * returns first name
     * @return first name
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * returns last name
     * @return last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * returns middle name
     * @return middle name
     */
    public String getMiddlename() {
        return middlename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name name)) return false;
        return Objects.equals(getFirstname(), name.getFirstname()) && Objects.equals(getLastname(), name.getLastname())
                && Objects.equals(getMiddlename(), name.getMiddlename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getMiddlename());
    }

    @Override
    public String toString(){
        if(middlename != null){
            return this.firstname +" "+this.lastname+" "+this.middlename;
        }
        return this.firstname +" "+this.lastname;
    }


}
