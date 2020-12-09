package week07.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void ofTest(){
        Date date = Date.of(2020,3,17);
        Assertions.assertEquals(2020,date.getYear());
        Assertions.assertEquals(3,date.getMonth());
        Assertions.assertEquals(17,date.getDay());
    }

    @Test
    public void withTest() {
        Date date = Date.of(2020,3,17);

        date = date.withDay(28);
        Assertions.assertEquals(2020,date.getYear());
        Assertions.assertEquals(3,date.getMonth());
        Assertions.assertEquals(28,date.getDay());

        date = date.withMonth(7);
        Assertions.assertEquals(2020,date.getYear());
        Assertions.assertEquals(7,date.getMonth());
        Assertions.assertEquals(28,date.getDay());

        date = date.withYear(1919);
        Assertions.assertEquals(1919,date.getYear());
        Assertions.assertEquals(7,date.getMonth());
        Assertions.assertEquals(28,date.getDay());
    }

    @Test
    public void excTest() {
        Exception ex = Assertions.assertThrows(Exception.class,() -> Date.of(-7,3,17));
        Assertions.assertEquals("Az év csak pozitív egész szám lehet",ex.getMessage());
        ex=null;

        Date date = Date.of(2020,4,29);
        ex = Assertions.assertThrows(Exception.class,() -> date.withDay(33));
        Assertions.assertEquals("Hibás nap",ex.getMessage().substring(0,9));
        ex= null;

        ex = Assertions.assertThrows(Exception.class,() -> date.withYear(2019));
        Assertions.assertEquals("Hibás nap",ex.getMessage().substring(0,9));
        ex= null;

    }
}
