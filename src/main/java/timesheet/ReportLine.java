package timesheet;

import java.util.Map;
import java.util.TreeMap;

public class ReportLine {
    private final Employee employee;
    private Map<Project,Integer> timeMap= new TreeMap<>();

    public ReportLine(Employee employee) {
        this.employee = employee;
    }
}
