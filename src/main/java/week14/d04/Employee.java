package week14.d04;

import java.util.Locale;

public class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Employee createWithUppercase () {
        return new Employee(getName().toUpperCase(Locale.ROOT));
    }
}
