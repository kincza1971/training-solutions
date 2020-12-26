package iozip.names;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path file, List<String> employees) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            zos.putNextEntry(new ZipEntry("names.dat"));
            for (String employee : employees) {
                zos.write(employee.getBytes(StandardCharsets.UTF_8));
                //zos.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file, data.dat");
        }
    }
}
