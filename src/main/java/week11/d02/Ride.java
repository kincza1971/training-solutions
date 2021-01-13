package week11.d02;

public class Ride {
    private final int day;
    private final int no;
    private final int distance;

    public Ride(int day, int no, int distance) {
        this.day = day;
        this.no = no;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getNo() {
        return no;
    }

    public int getDistance() {
        return distance;
    }
}
