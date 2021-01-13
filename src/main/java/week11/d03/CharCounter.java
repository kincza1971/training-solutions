package week11.d03;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CharCounter {

    private Set<Character> createCharList(String s) {
        Set<Character> chars = new TreeSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    public int countChars(String[] chars) {
        Set<Character> result = createCharList(chars[0]);
        Set<Character> setToCheck = new TreeSet<>();
        Set<Character> aktLine;
        for (String line : chars) {
            aktLine = createCharList(line);
            setToCheck.addAll(result);
            for (Character c : setToCheck) {
                if (!aktLine.contains(c)) {
                    result.remove(c);
                }
            }
        }
        return result.size();
    }
}
