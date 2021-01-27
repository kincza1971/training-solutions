package week12.d05.midlevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class WordCounter {
    public static final String WORD = "koronavírus";

    public static void main(String[] args) {
        System.out.println(new WordCounter().wordCounter());
        System.out.println(new WordCounter().wordCounter2());
    }

    public int wordCounter() {
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("index.txt"), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(WORD)) {
                    count++;
                }
            }
            return count;
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
    }

    public int wordCounter2() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(WordCounter.class.getResourceAsStream("index.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(WORD)) {
                    count++;
                }
            }
            return count;
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
    }
}