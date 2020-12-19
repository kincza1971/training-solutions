package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExampleStore {
    private List<String> exampleTitles = new ArrayList<>();

    public void readFromFile() {
        Path file = Path.of("examples.md");
        try {
            InputStream stream = ExampleStore.class.getResourceAsStream("examples.md");
            InputStreamReader isr = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("#")) {
                    exampleTitles.add(line);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong file name, or read error " + file.toString(),e);
        }
    }

    public List<String> getExampleTitles() {
        return new ArrayList<>(exampleTitles);
    }
}
