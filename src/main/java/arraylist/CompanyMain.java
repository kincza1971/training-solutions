package arraylist;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        Employee emp1 = new Employee("Kovács Gábor",1970);
        empList.add(emp1);

        Employee emp2 = new Employee("Kiss Péter",1975);
        empList.add(emp2);

        Employee emp3 = new Employee("Kellemetlen Kelemen",1947);
        empList.add(emp3);

        Employee emp4 = new Employee("Newwave Andrew",1990);
        empList.add(emp4);

        Company comp = new Company(empList);

        Employee emp5 = new Employee("Neumann Andrew",1990);

        comp.addEmployee(emp5);
        System.out.println(comp.listEmployeeNames().toString());

        System.out.println(comp.findEmployeeByName("Neumann Andrew").getName());

    }
}
