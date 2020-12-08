package week07.d02;

public interface User {
    String firstname="firstname";
    String lastname= "lastname";
    String userName = "userName";
    String getUsername();
    String getFirstName();
    String getLastName();

    default String getFullName() {
        return firstname + " " + lastname;
    };


    static User of () {
        return new User() {


            @Override
            public String getFullName() {
                return firstname + " "  + lastname;
            }

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

        };
    }

}
