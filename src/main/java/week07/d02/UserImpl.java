package week07.d02;

public class UserImpl implements User {

    private String firstname;
    private String lastname;
    private String userName;

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getFullName() {
        return firstname + " " + lastname;
    }

    public UserImpl(String firstname, String lastname, String userName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
    }
}
