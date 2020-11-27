package week02.d02.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserValidatorTest {

    private User user1 = new User("Mézga Aladár", 22);
    private User user2 = new User("Mézga Géza", -7);
    private User user3 = new User("Mézga Krisztina", 131);
    private User user4 = new User(null, 52);
    private User user5 = new User("", 52);

    private List<User> userList1 = new ArrayList<>(Arrays.asList(user1,user2,user3,user4));
    private List<User> userList2 = new ArrayList<>(Arrays.asList(user1,user3,user4));
    private List<User> userList3 = new ArrayList<>(Arrays.asList(user1,user4));
    private List<User> userList4 = new ArrayList<>(Arrays.asList(user1,user5));
    private List<User> userList5 = new ArrayList<>(Arrays.asList(user1));
    @Test
    public void userValidatorTest1() {

        Exception iax =  Assertions.assertThrows(InvalidUserException.class, () -> new UserValidator().validate(userList1));
        Assertions.assertEquals(iax.getMessage(),"Age of user is acceptable between 0 and 120 only");

        Exception iax2 =  Assertions.assertThrows(InvalidUserException.class, () -> new UserValidator().validate(userList2));
        Assertions.assertEquals(iax2.getMessage(),"Age of user is acceptable between 0 and 120 only");

        Exception iax3 =  Assertions.assertThrows(InvalidUserException.class, () -> new UserValidator().validate(userList3));
        Assertions.assertEquals(iax3.getMessage(),"Username must not null or empty");

        Exception iax4 =  Assertions.assertThrows(InvalidUserException.class, () -> new UserValidator().validate(userList4));
        Assertions.assertEquals(iax4.getMessage(),"Username must not null or empty");

    }
}
