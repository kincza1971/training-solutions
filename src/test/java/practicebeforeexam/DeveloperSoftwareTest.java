package practicebeforeexam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeveloperSoftwareTest {

    @Test
    void increasePrice() {
        DeveloperSoftware ds = new DeveloperSoftware("java", 100000);
        ds.increasePrice();
        assertEquals(110000, ds.getPrice(), 0.0005);
    }
}