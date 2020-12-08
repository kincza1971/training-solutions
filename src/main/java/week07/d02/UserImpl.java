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

    private void checkNames(String firstname, String lastname, String userName) {
        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException( "firstname cannot be null or empty");
        }
        if (lastname == null || lastname.isBlank()) {
            throw new IllegalArgumentException( "lastname cannot be null or empty");
        }
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException( "userName cannot be null or empty");
        }
    }

    public UserImpl(String firstname, String lastname, String userName) {
        checkNames(firstname,lastname,userName);
        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
    }
}
