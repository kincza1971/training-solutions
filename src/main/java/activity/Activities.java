package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not null");
        }
        activities.add(activity);
    }

    private List<Report> buildResultList(double[] distArray) {
        List<Report> reports= new ArrayList<>();
        for (int i = 0; i < distArray.length; i++) {
            reports.add(new Report(distArray[i],ActivityType.values()[i]));
        }
        return reports;
    }

    private double[] buildDistanceArray() {
        double[] distArray = new double[ActivityType.values().length];
        for (Activity activity : activities) {
            distArray[activity.getType().ordinal()] += activity.getDistance();
        }
        return distArray;
    }

    public List<Report> distancesByTypes() {
        double[] distArray = buildDistanceArray();
        return buildResultList(distArray);
    }


    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack){
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                counter++;
            }
        }
        return counter;
    }


    public Activities(List<Activity> activities) {
        this.activities = activities;
    }
}
