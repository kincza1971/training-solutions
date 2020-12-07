package week07.d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void fiboTest(){
        Fibonacci fb = new Fibonacci();
        int z = fb.fibonacci(1500);
        System.out.println(z);
        Assertions.assertEquals(8,fb.fibonacci(6));
    }
}
