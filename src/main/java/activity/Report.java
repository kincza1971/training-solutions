package activity;

public class Report {
    private final double distance;
    private final ActivityType activityType;

    public Report(double distance, ActivityType activityType) {
        this.distance = distance;
        this.activityType = activityType;
    }

    public double getDistance() {
        return distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }
}
