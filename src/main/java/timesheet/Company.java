package timesheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Company {

    private final InputStream employiesFile;
    private final InputStream projectsFile;

    private List<Employee> employees;
    private List<Project> projects;
    private List<TimesheetItem> timesheetItems;
    private Map<Employee,ReportLine> reportLineMap = new TreeMap<>();

    private void checkProject(Project project) {
        if (project == null || project.getName()== null || project.getName().isBlank()) {
            throw new IllegalArgumentException("Invalid project object");
        }
        if (!projects.contains(project)) {
            throw new IllegalArgumentException("Unknown project");
        }
    }

    private void checkEmployee(Employee employee) {
        if(employee == null || employee.getFirstname() == null || employee.getLastname() == null
            || employee.getFirstname().isBlank() || employee.getLastname().isBlank()) {
            throw new IllegalArgumentException("Invalid employee objeck");
        }
        if (!employees.contains(employee)) {
            throw new IllegalArgumentException("Unknown employee");
        }
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        checkProject(project);
        checkEmployee(employee);
        timesheetItems.add(new TimesheetItem(project,employee,beginDate,endDate));
    }

    private void parseAndAddEmployee(String line) {
        String[] lineParts = line.split(";");
    }

    private void readEmployees() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(employiesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseAndAddEmployee(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read employees from file");
        }
    }

    public Company(InputStream employiesFile, InputStream projectsFile) {
        this.employiesFile = employiesFile;
        this.projectsFile = projectsFile;
        readEmployees();
 //       readProjects()
    }
}
