package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameChangerTest {

    @Test
    void name() {

        NameChanger nc = new NameChanger("Kovács Géza");
        Assertions.assertEquals("Kovács Géza",nc.getFullName());
        nc.changeFirstName("Balogh");
        Assertions.assertEquals("Balogh Géza",nc.getFullName());
    }
}
