package week11.d04;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NameLength {

    public String getLength(List<String> strings) {
        Set<Integer> result = new TreeSet<>();
         for (String s : strings) {
             if (s.startsWith("J")) {
                 result.add(s.length());
             }
         }
         return result.toString();
    }

    public static void main(String[] args) {
        NameLength nl = new NameLength();
        System.out.println(nl.getLength(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }
}
