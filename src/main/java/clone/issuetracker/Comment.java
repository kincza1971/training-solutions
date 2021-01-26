package clone.issuetracker;

import java.time.LocalDateTime;

public class Comment {
    private final String text;
    private final LocalDateTime time;

    public Comment(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }
}
