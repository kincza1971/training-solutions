package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;


    private void checkData(double latitude, double longitude) {
        if (latitude<-90 || latitude>90) {
            throw new IllegalArgumentException("Latitude has to be between -90 and 90");
        }
        if (longitude<-180 || latitude>180) {
            throw new IllegalArgumentException("Longitude has to be between -180 and 180");
        }
    }


    public Coordinate(double latitude, double longitude) {
        checkData(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
