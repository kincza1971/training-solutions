package classstructuremethods;

public class Client {
    private String name;
    private int year;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public void migrate(String newaddress) {
        this.address = newaddress;
    }
}
