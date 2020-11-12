package introjunit;

import inrojunit.Gentleman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GentlemanTest {

    @Test
    void createTest() {

        Gentleman gentleman = new Gentleman();
        gentleman.sayHello("John Doe");

        Assertions.assertEquals(gentleman.sayHello("John Doe"),"Hellóka John Doe");

    }

}

