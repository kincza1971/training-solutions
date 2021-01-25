package week13.d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortByNameTest {
    SortByName sortByName = new SortByName();

    @Test
    public void testRead() {
        Exception e = Assertions.assertThrows(Exception.class,
                ()-> sortByName.getFirstCityInAbcFromFile(sortByName.getClass().getResourceAsStream("varosom.txt")));
        Assertions.assertEquals("Cannot read file",e.getMessage());
    }
    @Test
    public void testFindFirstInAbc() {
        Assertions.assertEquals("Aba", sortByName.getFirstCityInAbcFromFile(sortByName.getClass().getResourceAsStream("varosok.csv")));
        System.out.println(sortByName.readAndSort(sortByName.getClass().getResourceAsStream("varosok.csv")));
    }
}
