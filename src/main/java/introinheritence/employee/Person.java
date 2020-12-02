package introinheritence.employee;

public class Person {
    private String name;
    private String address;

    public void migrate(String newAddress) {
        this.address = newAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
