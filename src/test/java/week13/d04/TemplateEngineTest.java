package week13.d04;

import org.junit.jupiter.api.Test;
import stringmethods.url.Key;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngineTest {

    @Test
    public void testTemplate() throws IOException {
        BufferedReader br = Files.newBufferedReader(Path.of("template.txt"), StandardCharsets.UTF_8);
        BufferedWriter bw = Files.newBufferedWriter(Path.of("changed.txt"),StandardCharsets.UTF_8);
        TemplateEngine te = new TemplateEngine();
        Map<String,Object> values= new HashMap<>();
        values.put("nev","Mézga Aladár");
        values.put("datum", LocalDate.of(2021,01,30));
        values.put("osszeg",Double.valueOf(23412.5));
        values.put("hatarido",LocalDate.of(2021,04,30));


        te.merge(br,values,bw);
    }
}
