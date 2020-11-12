package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneParserTest {

    @Test
    void name() {

        Phone phone = new Phone("30-9914475");
        String prefix = phone.getPrefix();
        String number = phone.getNumber();
        Assertions.assertEquals("30", prefix);
        Assertions.assertEquals("9914475", number);
    }



}
