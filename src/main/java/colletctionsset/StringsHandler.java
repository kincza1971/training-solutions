package colletctionsset;

import java.util.*;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set set = new HashSet(stringCollection);
        return set;
    }
    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        setA.retainAll(setB);
        return setA;
    }

    private String randomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        int code;
        for (int i=0; i<length; i++) {
            code = random.nextInt('z'-'a'+1) + 'a';
            sb.append((char) code);
        }
        return sb.toString();
    }

    public String[] randomStringGenerator(int count, int length) {
        String[] randomStrings = new String[count];
        for (int i = 0; i<count; i++) {
            randomStrings[i] = randomString(length);
        }
        return randomStrings;
    }

    public Set<String> filterWords(String[] rndString) {
        Set<String> sortedUniqSet = new TreeSet<>();
        for (String s : rndString) {
            sortedUniqSet.add(s);
        }
        return sortedUniqSet;
    }

    public static void main(String[] args) {

        StringsHandler sh = new StringsHandler();
        System.out.println(sh.filterWords(sh.randomStringGenerator(30,3)));

    }


}
