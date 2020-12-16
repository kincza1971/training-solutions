package week08.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringListTest {

    List<String> testList = List.of("Alma", "bbb","aa", "bb", "CCC","pp");
    List<String> testList2 = List.of("Alma", "bbb","aa", "bb", "CCC","pp","s");

    @Test
    public void testException() {
        Exception ex = Assertions.assertThrows(Exception.class, () -> StringList.getShortestWords(null));
        Assertions.assertEquals("A lista nem lenet null, vagy üres", ex.getMessage());
        ex = Assertions.assertThrows(Exception.class, () -> StringList.getShortestWords(new ArrayList<>()));
        Assertions.assertEquals("A lista nem lenet null, vagy üres", ex.getMessage());
    }

    @Test
    public void testFilter() {
        Assertions.assertEquals(1,StringList.getShortestWords(testList2).size());
        Assertions.assertEquals("s",StringList.getShortestWords(testList2).get(0));
        Assertions.assertEquals("[aa, bb, pp]",StringList.getShortestWords(testList).toString());
    }
}
