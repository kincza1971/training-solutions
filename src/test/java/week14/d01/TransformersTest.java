package week14.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransformersTest {

    @Test
    void map() {

        assertEquals ( Arrays.asList(2, 3, 4), new Transformers().map(Arrays.asList(1, 2, 3), (value) -> value + 1));

    }

    @Test
    void reduce() {
        assertEquals(6,new Transformers().reduce(Arrays.asList(1, 2, 3), 0, Integer::sum));
    }
}