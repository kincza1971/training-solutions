package exam03;

import java.util.Objects;

public class Passenger implements Comparable<Passenger>{
    private final String name;
    private final CruiseClass cruiseClass;

    public Passenger(String name, CruiseClass cruiseClass) {
        this.name = name;
        this.cruiseClass = cruiseClass;
    }

    public String getName() {
        return name;
    }

    public CruiseClass getCruiseClass() {
        return cruiseClass;
    }

    @Override
    public int compareTo(Passenger o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && cruiseClass == passenger.cruiseClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cruiseClass);
    }
}
