package introdate;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {
        Performance performance = new Performance(
                "Michael Jackson",
                LocalDateTime.of(2020, 12, 14, 18, 30),
                LocalTime.of(22,40));
        System.out.println(performance.getArtist());
        System.out.println(performance.getStartTime());
        System.out.println(performance.getEndTime());
        System.out.println(performance.getInfo());
    }
}
