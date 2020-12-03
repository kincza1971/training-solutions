package introinheritance.employee;

public class Employee extends Person{

    private double salery;

    private void raiseSalary(int percent) {
        salery += salery*percent/100;
    }

    public double getSalary() {
        return salery;
    }

    public Employee(String name, String address, double salery) {
        super(name, address);
        this.salery = salery;
    }
}
