package week07.d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserImplTest {

    UserImpl u1 = new UserImpl("László","Farkas", "lfarkas");
    UserImpl u2 = new UserImpl("John","Doe", "jdoe");
    UserImpl u3 = new UserImpl("Jane","Doe", "jadoe");

    @Test
    public  void UserImpl() {
        Assertions.assertEquals("László Farkas",u1.getFullName());
        Assertions.assertEquals("jadoe",u3.getUsername());
    }

    @Test
    public  void userImpl2() {
        User u4 = u1;
        Assertions.assertEquals("lfarkas", u4.getUsername());
    }

    @Test
    public void throwTest() {
        //UserImpl u5 = new UserImpl(null,"","");

        Exception ex = Assertions.assertThrows(Exception.class,() -> new UserImpl(null,"",""));
        Assertions.assertEquals("firstname cannot be null or empty",ex.getMessage());
    }


}
