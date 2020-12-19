package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class LongWordService {

    public String writeWithStringWriter(List<String> words) {
        String result="";
        StringWriter sw = new StringWriter();
        try (sw){
            for (String word : words) {
                sw.write(word + ", " + word.length()+"\n");
            }
            result = sw.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not write", e);
        }
        return result;
    }
}
