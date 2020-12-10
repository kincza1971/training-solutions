package week07.d04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

public class ShoppingListTest {

    ShoppingList sl = new ShoppingList();

    @Test
    public void elsoTest() {
        long a = sl.calculateSum("src/items");
        try {
            System.out.println(Path.of(".").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }

}
