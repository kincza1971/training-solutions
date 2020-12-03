package introinheritance.employee;

public class BigBoss extends Boss {
    private double bonus;

    public double getSalary() {
        double salary = super.getSalary();
        salary += bonus;
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public BigBoss(String name, String address, double salery, int numberOfEmployees, double bonus) {
        super(name, address, salery, numberOfEmployees);
        this.bonus = bonus;
    }
}
