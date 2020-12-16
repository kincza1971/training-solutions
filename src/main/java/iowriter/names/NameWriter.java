package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

public class NameWriter {

    private final Path file;
    private List<String> names = new ArrayList<>();

    private void add(String name) {
        names.add(name);
    }

    private void writeToFile(String name) {
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardCharsets.UTF_8, APPEND)){
            bw.write(name + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAndWrite(String name) {
        add(name);
        writeToFile(name);
    }

    public NameWriter(Path file) {
        this.file = file;
    }
}
