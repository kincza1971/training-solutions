package ioreadstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final Path filePath;
    private List<Human> humans = new ArrayList<>();

    public FileManager(Path filePath) {
        this.filePath = filePath;
    }

    private Human parseHuman(String line) {
        String[] lineParts = line.split(";");
        return new Human(lineParts[0], lineParts[1]);
    }

    public void readFromFile () {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                humans.add(parseHuman(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file: " + filePath.toString(), e);
        }
    }
}
