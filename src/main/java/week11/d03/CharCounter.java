package week11.d03;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CharCounter {

    private Set<Character> createCharSet(String s) {
        Set<Character> chars = new TreeSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    public int countChars(String[] chars) {
        if ((chars == null) || (chars.length==0)) {
            throw new IllegalStateException("String array cannot be null opr empty");
        }
        Set<Character> result = createCharSet(chars[0]);
        Set<Character> setToCheck = new TreeSet<>();
        Set<Character> aktLine;
        for (String line : chars) {
            if (result.size() == 0) {
                return 0;
            }
            aktLine = createCharSet(line);
            setToCheck.addAll(result);
            for (char c : setToCheck) {
                if (!aktLine.contains(c)) {
                    result.remove(c);
                }
            }
        }
        return result.size();
    }
}
