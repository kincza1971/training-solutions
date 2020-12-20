package iowritesbytes.iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {


    public void writeAsBytes(List<String> stringList) {
        try (BufferedOutputStream br = new BufferedOutputStream(
                Files.newOutputStream(Path.of("/data.dat")))){
            for (String line : stringList) {
                if(!line.startsWith("_")) {
                    br.write(line.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }
    public void writeAsBytes(List<String> stringList,Path path) {
        try (BufferedOutputStream br = new BufferedOutputStream(
                Files.newOutputStream(path))){
            for (String line : stringList) {
                if(!line.startsWith("_")) {
                    br.write(line.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }
}
