package week14.d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Hachiko {
    private String word;

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

    private int countWordInLine(Object line) {
        String[] words = ((String) line).split(" ");
            return (int) Arrays.stream(words).filter(m -> m.contains(word)).count();
    }

    public int countAWord2(String param) {
        try {
            word =param;
            Path path = Path.of("src/main/resources/hachiko.srt");
            return Files.lines(path, StandardCharsets.UTF_8)
                    .filter(m -> m.contains(word))
                    .reduce(0,(sub,m) -> sub += countWordInLine(m),(a,b) -> a+b);

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public static void main(String[] args) {
        Hachiko hachiko = new Hachiko();
        System.out.println(hachiko.countAWord2("Hachi"));
    }
}
