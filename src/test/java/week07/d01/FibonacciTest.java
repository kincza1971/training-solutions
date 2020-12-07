package week07.d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void fiboTest(){
        Fibonacci fb = new Fibonacci();
        Assertions.assertEquals(8,fb.fibonacci(6));
    }
}
