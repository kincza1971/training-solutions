package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private final String name;
    private final LocalDateTime time;
    private Status status;
    private List<Comment> comments;

    public Issue(String name, LocalDateTime time) {
        this.name = name;
        this.time = time;
    }

    public Issue(String name, LocalDateTime time, Status status, List<Comment> comments) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comments = comments;
    }

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
        comments = new ArrayList<>();
    }

    public static Issue copy(Issue oldIssue, CopyMode copyMode) {
        if (copyMode == CopyMode.WITH_COMMENTS) {
            List<Comment> comments = new ArrayList<>(oldIssue.comments);
            return new Issue(oldIssue.name, oldIssue.time,oldIssue.status,comments);
        } else {
            return new Issue(oldIssue.name, oldIssue.time,oldIssue.status);
        }

    }
}
