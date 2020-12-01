package week06.d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StoreTest {

    Product p1 = new Product("Szilvásgombóc",Category.FROZEN,870);
    Product p2 = new Product("Túrógombóc",Category.FROZEN,970);
    Product p3 = new Product("Tejföl",Category.DAIRY,350);
    Product p4 = new Product("Gyümölcsjoghurt",Category.DAIRY,410);
    Product p5 = new Product("Sajtos perec",Category.BAKEDGOODS,240);
    Product p6 = new Product("Vizes zsemle",Category.BAKEDGOODS,70);
    Product p7 = new Product("Nosztalgia kifli",Category.BAKEDGOODS,120);
    Product p8 = new Product("Baugette",Category.BAKEDGOODS,449);
    Product p9 = new Product("Wunderbaum szilvás",Category.OTHER,690);
    Product p14 = new Product("Wunderbaum szilvás",Category.OTHER,690);
    Product p10 = new Product("Wunderbaum szilvás",Category.OTHER,690);
    Product p11 = new Product("Wunderbaum őszi avar",Category.OTHER,690);
    Product p12 = new Product("Wunderbaum döglött róka",Category.OTHER,690);
    Product p13 = new Product("Wunderbaum szivarfüst",Category.OTHER,690);

    Store store = new Store(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14));

    @Test
    public void testCreate() {
        Assertions.assertEquals(p1.getCategory(),Category.FROZEN);
    }

    @Test
    public void testToPrint() {
        System.out.println(store.toString());
        List<CategoryStock> stocks = store.getStockListByCategory();
        Assertions.assertEquals("[FROZEN: 2, DAIRY: 2, BAKEDGOODS: 4, OTHER: 6]", stocks.toString());
        Assertions.assertEquals("frozenQty: 2, diaryQty: 2, bakedGoodsQty: 4, otherQty: 6", store.getProductsByCategory().toString());
    }
}


