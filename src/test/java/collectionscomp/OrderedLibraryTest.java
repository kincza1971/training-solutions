package collectionscomp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderedLibraryTest {

    private OrderedLibrary library;


    @BeforeEach
    public void setUp() {
        List<Konyv> konyvList = new LinkedList<>(Arrays.asList(new Konyv(1245, "Őrület", "Utasy Kristóf"),
                new Konyv(2454, "Álom", "Ómolnár Géza"),
                new Konyv(5454, "Államhatár", "Ákos János"),
                new Konyv(5454, "Utitársak", "Ős János")));

        library = new OrderedLibrary(konyvList);
    }

    @Test
    public void testOrderedByTitle() {
        // Given
        List<Konyv> orderedKonyvList = library.orderedByTitle();
        //Then
        assertEquals("Utitársak", orderedKonyvList.get(0).getTitle());
    }

    @Test
    public void testOrderedByAuthor() {
        // Given
        List<Konyv> orderedKonyvList = library.orderedByAuthor();
        //Then
        assertEquals("Utasy Kristóf", orderedKonyvList.get(0).getAuthor());
    }

    @Test
    public void testOrderedByTitleLocale() {
        // Given
        List<String> orderedTitleList = library.orderedByTitleLocale(new Locale("hu", "HU"));
        //Then
        assertEquals("Államhatár", orderedTitleList.get(0));
    }
}