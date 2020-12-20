package week08.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class PlaneTest {

    Plane plane = new Plane();

    @Test
    public void planeTest() {
        int maxOcean = plane.flyOver("/map.txt");
        Assertions.assertEquals(16,maxOcean);
    }

}
