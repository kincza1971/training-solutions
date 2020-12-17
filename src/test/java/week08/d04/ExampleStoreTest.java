package week08.d04;

import org.junit.jupiter.api.Test;

public class ExampleStoreTest {

    ExampleStore as = new ExampleStore();

     @Test
    public void testAll(){
         as.readFromFile();
         System.out.println(as.getExampleTitles());
    }
}
