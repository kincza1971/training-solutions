package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cruise {
    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("No more place");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return getBasicPrice()*passenger.getCruiseClass().getClassRate();
    }

    public Passenger findPassengerByName(String name) {
        for(Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("Passenger does not exists");
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream()
                       .sorted()
                       .map(Passenger::getName)
                       .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream()
                   .mapToDouble(m -> getBasicPrice() * m.getCruiseClass().getClassRate())
                   .sum();
    }

    public Map<CruiseClass,Integer> countPassengerByClass() {
        Map<CruiseClass,Integer> countMap = new HashMap<>();
        for(Passenger passenger : passengers) {
            CruiseClass key = passenger.getCruiseClass();
            if (countMap.containsKey(key)) {
                countMap.put(key, countMap.get(key)+1);
            } else countMap.put(key, 1);
        }
        return countMap;
    }
}
