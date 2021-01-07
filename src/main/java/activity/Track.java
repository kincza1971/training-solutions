package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {
    public static final String COORDINATE = "<trkpt";
    public static final String ELEVATION = "<ele>";
    public static final int LAT_START_INDEX = 15;
    public static final int LAT_END_INDEX = 25;
    public static final int LON_START_INDEX = 32;
    public static final int LON_END_INDEX = 42;

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        if(trackPoints.contains(trackPoint)) {
            throw new IllegalArgumentException("This TrackPoint already added!");
        }
        trackPoints.add(trackPoint);
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = Double.MAX_VALUE;
        double minLong = Double.MAX_VALUE;
        for(TrackPoint p : trackPoints){
            if (minLat> p.getCoordinate().getLatitude()) {
                minLat = p.getCoordinate().getLatitude();
            }
            if (minLong > p.getCoordinate().getLongitude()) {
                minLong = p.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat,minLong);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = Double.MIN_VALUE;
        double maxLong = Double.MIN_VALUE;
        for(TrackPoint p : trackPoints){
            if (maxLat< p.getCoordinate().getLatitude()) {
                maxLat = p.getCoordinate().getLatitude();
            }
            if (maxLong < p.getCoordinate().getLongitude()) {
                maxLong = p.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat,maxLong);
    }

    public double getDistance() {
        double sumDist = 0;
        for(int i = 1; i<trackPoints.size();i++) {
            sumDist += trackPoints.get(i-1).getDistanceFrom(trackPoints.get(i));
        }
        return sumDist;
    }

    public double getFullDecrease() {
        double sumDec = 0;
        double elevation;
        for(int i = 1; i<trackPoints.size();i++) {
            elevation = trackPoints.get(i-1).getElevation() - trackPoints.get(i).getElevation();
            sumDec += elevation >0 ? elevation : 0;
        }
        return sumDec;
    }

    public double getFullElevation() {
        double sumE= 0;
        double elevation;
        for(int i = 1; i<trackPoints.size();i++) {
            elevation = trackPoints.get(i).getElevation() - trackPoints.get(i-1).getElevation();
            sumE += elevation >0 ? elevation : 0;
        }
        return sumE;
    }

    public double getRectangleArea() {
        Coordinate minPoint = findMinimumCoordinate();
        Coordinate maxPoint = findMaximumCoordinate();
        return (maxPoint.getLatitude()-minPoint.getLatitude()) * (maxPoint.getLongitude() - minPoint.getLongitude());
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }


    private double parseElevation(String line) {
        return Double.parseDouble(line.substring(9,14));
    }

    private Coordinate parseCoordinate(String line) {
        double lat= Double.parseDouble(line.substring(LAT_START_INDEX, LAT_END_INDEX));
        double lon= Double.parseDouble(line.substring(LON_START_INDEX, LON_END_INDEX));
        return new Coordinate(lat,lon);
    }

    public void loadFromGpx(InputStream is) {
        List<TrackPoint> tpl = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        Coordinate cord = null;
        try {
            while ((line = br.readLine()) != null) {
                if(line.trim().startsWith(COORDINATE)) {
                    cord = parseCoordinate(line);
                }
                if (line.trim().startsWith(ELEVATION)) {
                    tpl.add(new TrackPoint(cord,parseElevation(line)));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
        trackPoints = tpl;
    }


}
