package introinheritence.employee;

public class Boss extends Employee {
    private final double LEADERSHIP_FACTOR = 0.1;

    private int numberOfEmployees;

    public double getSalary(){
        double salery = super.getSalary();
        salery += salery * numberOfEmployees * LEADERSHIP_FACTOR;
        return  salery;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public Boss(String name, String address, double salery, int numberOfEmployees) {
        super(name, address, salery);
        this.numberOfEmployees = numberOfEmployees;
    }
}
