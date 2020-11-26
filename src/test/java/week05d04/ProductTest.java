package week05d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    private Product p1 = new Product(150,Currency.HUF);
    private Product p2 = new Product(2,Currency.USD);
    private Product p3 = new Product(300,"HUF");
    private Product p4 = new Product(4,"USD");

    @Test
    public void createTest(){
        Assertions.assertEquals(300.0,p3.getPrice());
        Assertions.assertEquals(Currency.HUF,p3.geteCurr());
        Assertions.assertEquals(4.0,p4.getPrice());
        Assertions.assertEquals(Currency.USD,p4.geteCurr());
    }

    @Test
    public void convertTest() {
        Assertions.assertEquals(1.0,p3.convertPrice("USD"));
        Assertions.assertEquals(0.5,p1.convertPrice("USD"));
        Assertions.assertEquals(1200.0,p4.convertPrice("HUF"));
        Assertions.assertEquals(4,p4.convertPrice("USD"));
    }

}
