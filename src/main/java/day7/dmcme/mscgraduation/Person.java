package day7.dmcme.mscgraduation;

public abstract class Person {

    private String firstName;
    private String lastName;

    /**
     * Constructor - for Person
     * @param firstName - String
     */

    public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    /**
     * Set Person First Name
     * @param firstName - String
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Return Person First Name
     * @return - String
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Set Last Name
     * @param lastName - String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get Last Name
     * @return - String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Return Full Name (First Name + Last Name)
     * @return - String
     */
    public String getFullName() {
        return  this.getFirstName() + " " + this.getLastName();
    }
}
