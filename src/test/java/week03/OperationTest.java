package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationTest {
    @Test
    void name() {

        Operation operation = new Operation("113 + 113");
        Assertions.assertEquals(226,operation.getResult());
    }
}
