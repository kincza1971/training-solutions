package ioreadstring;

public class Human {
    private final String lastname;
    private final String firstname;

    public Human(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }
}
