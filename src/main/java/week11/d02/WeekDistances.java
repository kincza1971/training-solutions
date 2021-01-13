package week11.d02;

public class WeekDistances {
    private final int day;
    private int distance;

    public WeekDistances(int day) {
        this.day = day;
        distance = 0;
    }

    public WeekDistances(int day, int distance) {
        this.day = day;
        this.distance = distance;
    }

    public void add(int dist) {
        distance += dist;
    }
}
