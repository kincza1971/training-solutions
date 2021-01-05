package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Travel {

    private int[] procLine(String line, int[] stations) {
        String[] parts = line.split(" ");
        if (!parts[4].equals("0")) {
            stations[Integer.parseInt(parts[0])] += stations[Integer.parseInt(parts[0])] + 1;
        }
        return stations;
    }

    public int getMax(int[] stations) {
        int max = -1;
        int station=-1;
        for (int i = 0; i<30; i++) {
            if (stations[i] >max) {
                max = stations[i];
                station = i;
            }
        }
        return station;
    }

    public int getStopWithMax() {
        Path path = Path.of("/utasadat.txt");
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
}
