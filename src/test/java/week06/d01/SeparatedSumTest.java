package week06.d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeparatedSumTest {

    private String s = "13,1;14,9;-11;-12;2";
    private SeparatedSum ss = new SeparatedSum();

     @Test
    public void sumTest() {
         SumResult sum = ss.sum(s);
         Assertions.assertEquals(-23.0, sum.getNegSum());
         Assertions.assertEquals(30.0, sum.getPosSum());
     }
}
