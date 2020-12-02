package week06.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SeriesTest {

    @Test
    public void incTest() {
        Series s = new Series();
        Assertions.assertEquals(1,s.calculateSeriesType(Arrays.asList(1,2,3,4)));
        Assertions.assertEquals(1,s.calculateSeriesType(Arrays.asList(1,2)));
        Assertions.assertEquals(0,s.calculateSeriesType(Arrays.asList(3,4,1)));
        Assertions.assertEquals(-1,s.calculateSeriesType(Arrays.asList(4,3,2,1)));
    }

}
