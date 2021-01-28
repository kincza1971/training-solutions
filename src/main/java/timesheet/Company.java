package timesheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    public static final int INDEX_OF_FIRSTNAME = 0;
    public static final int INDEX_OF_LASTNAME = 1;
    public static final String NAME_SEPARATOR = " ";
    private final InputStream employeesFile;
    private final InputStream projectsFile;

    private List<Employee> employees;
    private List<Project> projects;
    private List<TimeSheetItem> timesheetItems;

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

    private void checkEmployee(String employeeName) {
        String[] nameParts= employeeName.split(NAME_SEPARATOR);
        if (nameParts.length !=2) {
            throw new IllegalArgumentException("Invalid name");
        }
        Employee employee = new Employee(nameParts[INDEX_OF_FIRSTNAME],nameParts[INDEX_OF_LASTNAME]);
        checkEmployee(employee);

    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        checkProject(project);
        checkEmployee(employee);
        if (timesheetItems == null) {
            timesheetItems = new ArrayList<>();
        }
        timesheetItems.add(new TimeSheetItem(employee,project,beginDate,endDate));
    }

    private void parseAndAddEmployee(String line) {
        String[] lineParts = line.split(NAME_SEPARATOR);
        if (lineParts.length !=2) {
            throw new IllegalArgumentException("Wrong employee line, " + line);
        } else {
            employees.add(new Employee(lineParts[INDEX_OF_FIRSTNAME],lineParts[INDEX_OF_LASTNAME]));
        }

    }

    private void readEmployeesFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(employeesFile, StandardCharsets.UTF_8))) {
            String line;
            employees = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                parseAndAddEmployee(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read employees from file");
        }
    }

    private void readProjectsFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(projectsFile,StandardCharsets.UTF_8))) {
            String line;
            projects = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read employees from file");
        }
    }

    private void addToReportLines(List<ReportLine> reportLines,TimeSheetItem timeSheetItem) {
        Project project=timeSheetItem.getProject();
        ReportLine reportLine = new ReportLine(project,timeSheetItem.hoursBetweenDates());

        if(reportLines.contains(reportLine)) {
            reportLines.get(reportLines.indexOf(reportLine)).addTime(reportLine.getTime());
        } else reportLines.add(reportLine);

    }

    private List<ReportLine> addAllProjectToReport() {
        List<ReportLine> reportLines = new ArrayList<>();
        for (Project project : projects) {
            reportLines.add(new ReportLine(project,0L));
        }
        return reportLines;
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        checkEmployee(employeeName);
        List<ReportLine> reportLines = addAllProjectToReport();
        for (TimeSheetItem timeSheetItem : timesheetItems) {
            if(timeSheetItem.getEmployee().getName().equals(employeeName) &&
                timeSheetItem.getBeginDate().getYear() == year &&
                timeSheetItem.getBeginDate().getMonthValue() == month) {
                addToReportLines(reportLines,timeSheetItem);
            }
        }
        return reportLines;
    }

    private String createHeader(List<ReportLine> reportLines, String name,int year, int month){
        long sum =0;
        for (ReportLine reportLine : reportLines) {
            sum += reportLine.getTime();
        }
        if (sum >0) {
            return String.format("%s\t%d-%02d\t%d\n", name, year, month, sum);
        } else {
            throw new IllegalArgumentException("Nincs teljesítés");
        }
    }

    public List<String> createReport(List<ReportLine> reportLines,String name, int year, int month) {
        List<String> report = new ArrayList<>();
        report.add(createHeader(reportLines, name, year, month));
        for (ReportLine reportLine : reportLines) {
            if (reportLine.getTime()>0) {
                report.add(reportLine.getProject().getName() + "\t" + reportLine.getTime() + "\n");
            }
        }
        return report;
    }

    public void printToFile(String name, int year, int month, Path file) {
        List<ReportLine> reportLines = calculateProjectByNameYearMonth(name,year,month);
        List<String> report = createReport(reportLines,name,year,month);
        try (BufferedWriter br = Files.newBufferedWriter(file)) {
            for(String line : report) {
                br.write(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }

    public Company(InputStream employeesFile, InputStream projectsFile) {
        this.employeesFile = employeesFile;
        this.projectsFile = projectsFile;
        readEmployeesFromFile();
        readProjectsFromFile();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<TimeSheetItem> getTimesheetItems() {
        return timesheetItems;
    }

}
