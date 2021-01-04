package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    private static final String SOURCE_DIR = "/install/";

    private Path checkPath(String pathToCheck) {
        if (pathToCheck == null || pathToCheck.isBlank()){
            throw new IllegalArgumentException("Path cannot be null or empty");
        }
        Path result = Path.of(pathToCheck);
        if (Files.isDirectory(result)) {
            throw new IllegalStateException("Not a file");
        }
        return result;
    }

    private void processLine(Path target, String line) {
        try {
            if (line.endsWith("/")) {
                Files.createDirectories(Path.of(line));
            } else {
                Files.copy(Path.of(SOURCE_DIR,line), target.resolve(line), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void install(String strPath) {
        Path target = Path.of(strPath);//checkPath(strPath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("install.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(target, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
