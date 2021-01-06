package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Travel {

    public static final int INDEX_OF_STATION = 0;

    private int[] procLine(String line, int[] stations) {
        String[] parts = line.split(" ");
 //       if (!parts[4].equals("0")) {
            stations[Integer.parseInt(parts[INDEX_OF_STATION])]++;
//        }
        return stations;
    }

    public int getMax(int[] stations) {
        int maxPos = 0;
        for (int i = 0; i<stations.length; i++) {
            if (stations[i] >stations[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }

    public int getStopWithMax() {
        Path path = Path.of("src", "main","resources","utasadat.txt");
        int[] stations = new int[30];
        String line;
        try (BufferedReader br = Files.newBufferedReader(path)) {

            while ((line = br.readLine()) != null) {
                procLine(line, stations);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
        return getMax(stations);
    }

    public static void main(String[] args) {
        Travel t = new Travel();
        int i =t.getStopWithMax();
        System.out.println(i);
    }
}
