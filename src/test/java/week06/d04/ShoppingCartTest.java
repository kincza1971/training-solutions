package week06.d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ShoppingCartTest {

    @Test
    public void createTest() {
        ShoppingCart sc = new ShoppingCart();

        Exception ex = assertThrows(IllegalArgumentException.class,() ->sc.addItem("", 3));
        Assertions.assertEquals(ex.getMessage(),"Name cannot be null or empty");
        sc.addItem("Cukor", 5);
//        sc.addItem("Cukor", -5);
        Assertions.assertEquals(5,sc.getItem("cukor"));
    }
    @Test
    public void incTest() {
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("Só", 3);
        Assertions.assertEquals(3,sc.getItem("só"));
        sc.addItem("Só", 3);
        Assertions.assertEquals(6,sc.getItem("só"));
        sc.addItem("Só", -2);
        Assertions.assertEquals(4,sc.getItem("só"));
        sc.addItem("Cukor", 5);
        Assertions.assertEquals(5,sc.getItem("cukor"));
        System.out.println(sc.getItemList());
    }

}
