package week02.d02.d03;

import java.util.List;

public class UserValidator {

    private boolean isInvalidName(User user){
        String name = user.getName();
        return (name == null || name.isBlank());
    }

    private boolean isInvalidAge(User user){
        int age = user.getAge();
        return (age<0 || age > 120);
    };


    public void validate(List<User> userList) throws InvalidUserException {
        for (User user : userList) {
            if (isInvalidName(user)) {
                throw new InvalidUserException("Username must not null or empty");
            }
            if (isInvalidAge(user)) {
                throw new InvalidUserException("Age of user is acceptable between 0 and 120 only");
            }
        }
    }


}
