package colletctionshashset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RandomStringGenerator {

    public Collection<String> createStrings(int length, int count) {
        Collection<String> stringCollection = new ArrayList<>(count);
        for (int i = 0; i<count; i++) {
            stringCollection.add(randomString(length));
        }
        return stringCollection;
    }

    private String randomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        int code;
        for (int i=0; i<length; i++) {
            code = random.nextInt('z'-'a') + 'a';
            sb.append((char) code);
        }
        return sb.toString();
    }
}
