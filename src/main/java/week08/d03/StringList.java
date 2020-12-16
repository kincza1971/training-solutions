package week08.d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    private List<String> checkParam(List <String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("A lista nem lenet null, vagy üres");
        }
        return new ArrayList<>();
    }

    public  List<String> getShortestWords(List<String> words) {
        List<String> shortestWords = checkParam(words);
        int minLength = Integer.MAX_VALUE;
        int length;
        for (String word : words) {
            length = word.length();
            if (length <= minLength) {
                if (length < minLength) {
                    minLength = length;
                    shortestWords.clear();
                }
                shortestWords.add(word);
            }
        }
        return new ArrayList<>(shortestWords);
    }
}
