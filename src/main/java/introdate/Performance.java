package introdate;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Performance {
    public String artist;
    public LocalDateTime startTime;
    public LocalTime endTime;

    public Performance (String artist, LocalDateTime startTime, LocalTime endTime) {
        this.endTime = endTime;
        this.artist = artist;
        this.startTime = startTime;
    }

    public String getArtist() {
        return this.artist;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getInfo() {
        return artist + ": " + startTime.toLocalDate().toString() + " " + startTime.toLocalTime() + " - " + endTime;
    }

}
