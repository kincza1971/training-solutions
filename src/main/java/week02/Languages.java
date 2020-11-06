package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    private List<String> prgs = new ArrayList<>();

    public static void main(String[] args) {
        Languages lang = new Languages();

        lang.prgs.add("Java");
        lang.prgs.add("Python");
        lang.prgs.add("JavaScript");

        for (String lg: lang.prg) {
            if (lg.length()>5) {
                System.out.println(lg);
            }
        }

    }
}
