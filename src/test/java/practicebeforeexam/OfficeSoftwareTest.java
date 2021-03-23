package practicebeforeexam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        OfficeSoftware os = new OfficeSoftware("Editor", 10000);
        os.increasePrice();
        assertEquals(10500, os.getPrice(), 0.0005);
    }
}