package week11.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Courier {

    List<Ride> rides = new ArrayList<>();

    public void readFile() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Courier.class.getResourceAsStream("/rides.txt")))) {
            while ((line = br.readLine()) != null) {
                String[] parts= line.split(" ");
                rides.add(new Ride (Integer.parseInt(parts[0]),
                                    Integer.parseInt(parts[1]),
                                    Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
    }

    public List<WeekDistances> initList() {
        List<WeekDistances> distances= new ArrayList<>();
        for (int i = 1 ; i<8 ; i++) {
            distances.add(new WeekDistances(i,0));
        }
        return distances;
    }

    public List<WeekDistances> getDistanceByDay() {
        List<WeekDistances> distances= initList();
        for (Ride ride : rides) {
            distances.get(ride.getDay()).add(ride.getDistance());
        }
        return new ArrayList<>(distances);
    }

    public Ride getFirstRide() {
        int minDay = 8;
        Ride firstRide = null;
        for (Ride ride : rides) {
            if(ride.getDay() < minDay) {
                minDay = ride.getDay();
                if ( ride.getNo() == 1) {
                    firstRide = ride;
                }
            }
        }
        return firstRide;
    }

    public List<WeekDistances> getMissingDays() {
        return null;
    }

}
