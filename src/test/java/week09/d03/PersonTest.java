package week09.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonTest {

    Random random = new Random(2);

    Person p1 = new Person("Gazsi", 23, random);
    Person p2 = new Person("Ferike", 7, random);
    Person p3 = new Person("Armadócska", 11, random);

    @Test
    public void presents() {
        p1.setPresent();
        p2.setPresent();
        p3.setPresent();
        Assertions.assertEquals(Present.HOUSEKEEPING,p1.getPresent());
        Assertions.assertEquals(Present.ELECTRONIC,p2.getPresent());
        Assertions.assertEquals(Present.DECORATION,p3.getPresent());
    }

    @Test
    public void createPersonTest() {
        Exception e = Assertions.assertThrows(Exception.class, () -> new Person(null,11,random));
        Assertions.assertEquals("Name must not null or blank, (null)",e.getMessage());
        e = Assertions.assertThrows(Exception.class, () -> new Person("",11,random));
        Assertions.assertEquals("Name must not null or blank, ()",e.getMessage());
        e = Assertions.assertThrows(Exception.class, () -> new Person("Rómeócska",-7,random));
        Assertions.assertEquals("Age must be between 0 and 120, (-7)",e.getMessage());
    }

    @Test
    public void santaTest() {
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        SantaClaus santa = new SantaClaus(people);
        people = santa.getThroughChimneys();
        Assertions.assertEquals(2,people.size());
        Assertions.assertEquals(Present.HOUSEKEEPING,people.get(0).getPresent());
    }


}
