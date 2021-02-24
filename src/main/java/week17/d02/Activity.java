package week17.d02;

import java.time.LocalDateTime;

public class Activity {
    private long id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType activityType;

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType activityType) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType activityType) {
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public static Activity activityById(long id, Activity activity) {
        return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getActivityType());
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
