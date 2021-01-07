package activity;

public class ActivityWithoutTrack implements Activity{

    private ActivityType activityType;

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }

    public ActivityWithoutTrack(ActivityType activityType) {
        this.activityType = activityType;
    }
}
