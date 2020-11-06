package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {
        List<String> prgs = new ArrayList<>();

        Languages lang = new Languages();

        prgs.add("Java");
        prgs.add("Python");
        prgs.add("JavaScript");

        for (String lg: prgs) {
            if (lg.length()>5) {
                System.out.println(lg);
            }
        }

    }
}
