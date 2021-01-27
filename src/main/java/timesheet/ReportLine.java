package timesheet;


import java.util.Comparator;
import java.util.Objects;

public class ReportLine {
    private final Project project;
    private long time;

    public ReportLine(Project project) {
        this.project = project;
    }

    public ReportLine(Project project, double time) {
        this.project = project;
        this.time += time;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long hours) {
        time += hours;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportLine that = (ReportLine) o;
        return Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project);
    }
}
