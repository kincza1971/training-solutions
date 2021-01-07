package activity;

public class ActivityWithTrack implements Activity{

    private ActivityType activityType;
    private Track track;

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }

    public ActivityWithTrack(Track track,ActivityType activityType) {
        this.activityType = activityType;
        this.track = track;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Track getTrack() {
        return track;
    }
}
