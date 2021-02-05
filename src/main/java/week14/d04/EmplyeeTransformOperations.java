package week14.d04;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmplyeeTransformOperations {

    private List<Employee> employees;

    public List<Employee> transformToUppercased(List<Employee> employees) {
        return employees.stream()
                .map(Employee::createWithUppercase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        EmplyeeTransformOperations eto = new EmplyeeTransformOperations();
        System.out.println(eto.transformToUppercased(List.of(
                new Employee("Gejza"),
                new Employee("pesta"),
                new Employee("Gazsi")
        ))
        );
    }
}
