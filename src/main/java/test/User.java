package test;

import java.util.Locale;
import java.util.function.Function;

public class User
{
    public String name;
    public User(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public Function<User,String> getUserUpperName (User u) {
        return user -> user.getName().toUpperCase(new Locale("hu","HU"));
    }
}