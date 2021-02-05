package week14.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hachiko {

    public long countAWord(String word) {
        try {
            int sum = 0;
            Path path = Path.of("src/main/resources/hachiko.srt");
            return Files.lines(path)
                    .filter(m -> m.contains(word))
                    .count();

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public static void main(String[] args) {
        Hachiko hachiko = new Hachiko();
        System.out.println(hachiko.countAWord("Hachi"));
    }
}
