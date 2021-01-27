package week13.d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BookSelectorTest {
    @Test
    public void testBookSelector() {
        BookSelector bs = new BookSelector();
        String author =bs.getAuthorWithMostPages(
                Arrays.asList(
                        new Book("Rejtő Jenő", "Elveszett cirkáló",185),
                        new Book("Rejtő Jenő", "Piszkos Fred a kapitány",185),
                        new Book("Rejtő Jenő", "Utolsó helyőrség",185),
                        new Book("Friderikusz", "Majmok bolygója: Főld",185)
                )
        );
        Assertions.assertEquals("Rejtő Jenő", author);
    }
}
