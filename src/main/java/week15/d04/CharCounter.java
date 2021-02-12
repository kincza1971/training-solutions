package week15.d04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounter {

    private CharType checkAChar (int c) {

        String s = String.valueOf((char)c);

        if ("aeiíouúüűéáöőó".contains(s)) {
            return CharType.VOWEL;
        }

        if ("yYqwrtzpsdfghjklxcvbnm".contains(s)) {
            return CharType.CONSONANT;
        }

        return CharType.OTHER;

    }

    public Map<CharType,Integer> countChars(Path p) {

        try (Stream<String> lines =  Files.lines(p, StandardCharsets.UTF_8)){
            return lines.map(String::toLowerCase)
                           .flatMapToInt(String::chars)
                           .filter(i -> i != (int) ' ')
                           .mapToObj(this::checkAChar)
                           .collect(Collectors.toMap(m->m ,m->1 ,Integer::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<CharType,Long> countChars2(Path p) {

        try (Stream<String> lines =  Files.lines(p, StandardCharsets.UTF_8)){
            return lines.map(String::toLowerCase)
                           .flatMapToInt(String::chars)
                           .filter(i -> i != (int) ' ')
                           .mapToObj(this::checkAChar)
                           .collect(Collectors.groupingBy(m->m, Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CharCounter cc = new CharCounter();
        System.out.println(cc.countChars(Path.of("src/main/resources/hachiko.srt")));
        System.out.println(cc.countChars2(Path.of("src/main/resources/hachiko.srt")));
    }
}
