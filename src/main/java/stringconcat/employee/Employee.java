package stringconcat.employee;

public class Employee {

    private String name;
    private String position;
    private int salery;

    public Employee(String name, String position, int salery) throws IllegalArgumentException {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Név megadása kötelező.");
        }
        this.name = name;

        if(position == null || position == "") {
            throw new IllegalArgumentException("Foglalkoz megadása kötelező.");
        }
        this.position = position;

        if((salery%1000 != 0) || (salery<0)) {
            throw new IllegalArgumentException("A fizetés csak 1000-el osztható pozítív szám lehet.");
        }
        this.salery = salery;
    }

    @Override
    public String toString() {
        return name + " - " + position + " - " + salery + " Ft";
    }
}
