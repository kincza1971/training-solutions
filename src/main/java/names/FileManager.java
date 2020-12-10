package names;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileManager {
    List<Human> humans;

    private void getFromFile(String filePath)  {
        Path file = Path.of(filePath);
        try {
            Files.readAllLines(file);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
    }
}
