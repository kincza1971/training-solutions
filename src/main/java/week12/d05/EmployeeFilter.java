package week12.d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    private void checkList(List<Employee> employees) {
        if (employees == null || employees.isEmpty() || employees.contains(null)) {
            throw new IllegalArgumentException("List must not null or empty and employee = null is not allowed here");
        }
    }

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        checkList(employees);
        List<Employee> selected = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getSkillLevel() >= 3 && employee.getSkills().contains("programmer")) {
                selected.add(employee);
            }
        }
        return selected;
    }
}
