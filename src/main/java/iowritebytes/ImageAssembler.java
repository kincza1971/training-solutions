package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {


    public void makeImageFile(byte[][] bytes, Path path) {
        Path file = Path.of(path.toString(),"image.png");
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            byte[] point;
            for (int i = 0; i < bytes.length; i++) {
                point = bytes[i];
                os.write(point);
            }
        } catch (IOException e) {
            new IllegalStateException("Can not write", e);
        }
    }
}
