package week08.d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SultanTest {

    @Test
    public void createTest() {
        Sultan sultan = new Sultan();
        Assertions.assertEquals("1, 4, 9, 16, 25, 36, 49, 64, 81, 100", sultan.openDoors());

        sultan = new Sultan(1,5);
        Assertions.assertEquals("1, 2, 3, 4, 5", sultan.openDoors());

        sultan = new Sultan(2,6);
        Assertions.assertEquals("1, 3, 5", sultan.openDoors());

        sultan = new Sultan(3,6);
        Assertions.assertEquals("1, 5, 6", sultan.openDoors());

    }

    @Test
    public void throwTest() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,() -> new Sultan(-2,20));
        Assertions.assertEquals("A napok és az ajtók száma csak 0-nál nagyobb lehet (-2, 20)", ex.getMessage());
    }

}
