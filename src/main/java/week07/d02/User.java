package week07.d02;

public interface User {
    String getUsername();
    String getFirstName();
    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    };


    static User of (String firstname, String lastname, String userName) {
        return new UserImpl(firstname,lastname,userName);
    }

}
