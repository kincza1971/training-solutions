package week10.d01;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void getPlusElevation() {
        Path datafile = Path.of("gpsdata.txt");
        HikingFile hf = new HikingFile();
        Differences differences = hf.getPlusElevation(HikingFile.class.getResourceAsStream("gpsdata.txt"));
        System.out.println("" + differences.getIncreasing() + ", " +differences.getDecreasing());
    }

}