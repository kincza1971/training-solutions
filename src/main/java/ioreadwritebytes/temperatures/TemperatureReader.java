package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperatureReader {
    public Temperatures readTemperatures(String path) {
        Path file = Path.of(path);
        byte[] temps;
        try {
            temps = Files.readAllBytes(file);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return new Temperatures(temps);
    }
}
