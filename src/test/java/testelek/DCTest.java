package testelek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DCTest {

    @Test
    void getCountsOfDigits() {
        DC dc = new DC();
        assertEquals(3, dc.getCountsOfDigits("AA123"));
        assertEquals(3, dc.getCountsOfDigits("AA123331"));
        assertEquals(10, dc.getCountsOfDigits("AA00112233445566778899"));
    }
}