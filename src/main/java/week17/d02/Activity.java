package week17.d02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private long id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType activityType;
    private List<TrackPoint> trackPoints;

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType activityType, List<TrackPoint> trackPoints) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
        this.trackPoints = trackPoints;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType activityType) {
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
        this.trackPoints = new ArrayList<>();
    }

    public static Activity activityById(long id, Activity activity) {
        return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getActivityType(),
                activity.getTrackPoints());
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    @Override
    public String toString() {
        return "Activity{" +
                       "id=" + id +
                       ", startTime=" + startTime +
                       ", desc='" + desc + '\'' +
                       ", activityType=" + activityType +
                       '}';
    }
}
