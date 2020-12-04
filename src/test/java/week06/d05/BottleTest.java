package week06.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BottleTest {

    private Bottle pet = Bottle.of(BottleType.PET_BOTTLE);
    private Bottle glass = Bottle.of(BottleType.GLASS_BOTTLE);

    @Test
    public void fillTest() {
        glass.fill(10);
        Assertions.assertEquals(10,glass.getFilledUntil());
        glass.fill(10);
        Assertions.assertEquals(20,glass.getFilledUntil());
    }

    @Test

    private void exceptTest() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () ->pet.fill(10));
        Assertions.assertEquals("A palackba nem fér ennyi folyadék!", ex.getMessage());
    }
}
