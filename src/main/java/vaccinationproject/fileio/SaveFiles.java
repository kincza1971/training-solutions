package vaccinationproject.fileio;

import vaccinationproject.guis.MessagePrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SaveFiles {

    private final MessagePrinter mp;

    public SaveFiles(MessagePrinter mp) {
        this.mp = mp;
    }

    public void writeStringListToFile(Path path, List<String> linesToWrite, String header) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            bw.write(header + System.lineSeparator());
            for (String line : linesToWrite) {
                bw.write(line + System.lineSeparator());
            }
            mp.printGreen("File saved to: " + path.toString());
        } catch (IOException e) {
            mp.printRed("Cannot open or create file:" + path.toString());
        }
    }

}
