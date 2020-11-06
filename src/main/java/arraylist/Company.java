package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Company {
    List<Employee> company = new ArrayList<>();

    public Company(List<Employee> company) {
        this.company = company;
    }
    public void addEmployee(Employee newEmploye) {
        company.add(newEmploye);
    }
    public Employee findEmployeeByName(String name) {
        int i = -1;
        for (Employee anEmployee: company) {
            if (name.equals(anEmployee.getName())) {
                i = company.indexOf(anEmployee);
            }
        }
        return company.get(i);
    }

    public List<String> listEmployeeNames() {
        List<String> res = new ArrayList<>();
        for (Employee e: company) {
            res.add(e.getName());
        }
        return res;
    }

}
