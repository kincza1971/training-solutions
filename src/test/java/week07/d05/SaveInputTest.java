package week07.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SaveInputTest {
    SaveInput2 si = new SaveInput2();

     @Test
    public void siTest() throws IOException {
         si.writeToFile(List.of("Alma", "Körte", "Narancs"),"alma.txt");
         List<String> data;
         Path file = Path.of("alma.txt");
         data = Files.readAllLines(file, StandardCharsets.UTF_8);
         Assertions.assertEquals("Alma",data.get(0));
     }
}
