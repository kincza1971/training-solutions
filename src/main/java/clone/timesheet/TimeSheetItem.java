package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private final String employee;
    private final String project;
    private final LocalDateTime from;
    private final LocalDateTime to;

    public static TimeSheetItem otherDay(TimeSheetItem oldTSI,LocalDate newDate) {
        return new TimeSheetItem(oldTSI.employee, oldTSI.project,
                LocalDateTime.of(newDate,oldTSI.from.toLocalTime()),
                LocalDateTime.of(newDate,oldTSI.to.toLocalTime()));
    }

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }


    public TimeSheetItem copy(TimeSheetItem fromTSI) {
        return new TimeSheetItem(fromTSI.employee,fromTSI.project, fromTSI.from, fromTSI.to);
    }
}
