package week09.d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {
    List<Person> people = new ArrayList<>();

    public List<Person> getThroughChimneys() {
        List<Person> hasToVisit = getListToVsit();
        if (hasToVisit.isEmpty()) {
            throw new IllegalStateException("There is no person in the list");
        }
        return new ArrayList<>(hasToVisit);
    }

    private List<Person> getListToVsit() {
        List<Person> hasToVisit = new ArrayList<>();
        for (Person person : people) {
            person.setPresent();
            hasToVisit.add(person);
        }
        return hasToVisit;
    }

    public SantaClaus(List<Person> people) {
        if (people == null || people.isEmpty()) {
            throw new IllegalArgumentException("Person list must not null");
        }
        this.people = people;
    }
}


