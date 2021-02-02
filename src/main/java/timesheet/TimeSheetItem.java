package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private final Project project;
    private final Employee employee;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public double hoursBetweenDates() {
        return Duration.between(beginDate,endDate).toHours();
    }

    private void checkDateParams(LocalDateTime beginDate, LocalDateTime endDate) {
        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("Date most not null");
        }
        if (beginDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Begin date has to be earlier than end date");
        }
        if (!beginDate.toLocalDate().equals(endDate.toLocalDate())) {
            throw new IllegalArgumentException("Start and end date has to be on same day");
        }
        if (!beginDate.toLocalDate().equals(endDate.toLocalDate())) {
            throw new IllegalArgumentException("Dates need to be on same day");
        }
    }

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        checkDateParams(beginDate,endDate);
        this.project = project;
        this.employee = employee;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
