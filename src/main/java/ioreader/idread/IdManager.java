package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> idList = new ArrayList<>();

    public void readIdsFromFile(String fileName){
        Path file = Path.of("src", "main", "resources",fileName);
        try (BufferedReader bfr = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while ((line = bfr.readLine()) != null) {
                idList.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Not valid file name, " + fileName);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(idList) ;
    }
}
