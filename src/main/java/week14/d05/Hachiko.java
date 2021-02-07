package week14.d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Hachiko {
    private String word;

    public long countAWord2(String param) {
        word =param;
        Path path = Path.of("src/main/resources/hachiko.srt");
        try( Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            return
                    lines.filter(isLineContainsWord(word))
                            .flatMap(this::splitLineToWords)
                            .filter(isLineContainsWord(word))
                            .count();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public long countAWord3(String param) {
        word =param;
        Path path = Path.of("src/main/resources/hachiko.srt");
        try( Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            return
                    lines.filter(isLineContainsWord(word))
                            .mapToInt(this::countWordInLine)
                            .sum();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public long countAWord4(String param) {
        word =param;
        Path path = Path.of("src/main/resources/hachiko.srt");
        try( Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            return
                    ((long) lines.filter(isLineContainsWord(word))
                            .reduce(0, (sub,line) ->sub +=countWordInLine(line), Integer::sum));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private Stream<? extends String> splitLineToWords(String m) {
        return (Arrays.stream(m.split(" ")));
    }

    public long countAWord(String word) {
        Path path = Path.of("src/main/resources/hachiko.srt");
        try (Stream<String> lines = Files.lines(path,StandardCharsets.UTF_8)){
            return lines
                    .filter(isLineContainsWord(word))
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
    }

    private int countWordInLine(Object line) {
        String[] words = ((String) line).split(" ");
        return (int) Arrays.stream(words).filter(isLineContainsWord(word)).count();
    }

    private Predicate<String> isLineContainsWord(String word) {
        return m -> m.contains(word);
    }

    public static void main(String[] args) {
        Hachiko hachiko = new Hachiko();
        System.out.println(hachiko.countAWord("Hach"));
        System.out.println(hachiko.countAWord2("Hach"));
    }
}
