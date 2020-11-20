package week04;


import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        for (Integer i=0; i< str.length();i++)
            if (c == str.charAt(i)) result.add(i);
        return result;
    }

        public static void main(String[] args) {
           List<Integer> intlist = getIndexesOfChar("alma alma piros alma", 'a');
           for (int i : intlist) {
               System.out.println(i);
           }
        }


}
