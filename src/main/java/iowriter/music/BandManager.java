package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();
//    private final Path sourceFile = Path.of("src", "main", "resources", "band_and_names.txt");

    private Band processLine(String line) {
        String [] fields = line.split(";");
        return new Band(fields[0],Integer.parseInt(fields[1]));
    }

    public void readBandsFromFile(Path file) {
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            bands = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                bands.add(processLine(line));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong filename, " + file.getName(0), e);
        }
    }

    public void writeBandsBefore(Path file, int yearBefore){
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
            for (Band band : bands) {
                if (band.getYear()< yearBefore) {
                    bw.write(band.getName() + ";" + Integer.toString(band.getYear()) + "\n");
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }


}
