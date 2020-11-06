package week02;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

public class Languages {
    List<String> prg = new ArrayList<>();
    public static void main(String[] args) {
        Languages lang = new Languages();
        lang.prg.add("Java");
        lang.prg.add("Python");
        lang.prg.add("JavaScript");

        for (String lg: lang.prg) {
            if (lg.length()>5) {
                System.out.println(lg);
            }
        }

    }
}
