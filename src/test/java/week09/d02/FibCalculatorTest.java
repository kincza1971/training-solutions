package week09.d02;

import org.junit.jupiter.api.Test;

public class FibCalculatorTest {

    //0 1 1 2 3 5 8 13 21 34
    //0   1   4   12   33

    @Test
    public void calcTest() {
        FibCalculator fc = new FibCalculator();
        double sum = fc.sumEvens(40);
        System.out.println(sum);
    }
}

