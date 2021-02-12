package week15.d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PostFinderTest {


    private List<Post> testData = List.of(
            new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
            new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
            new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista")
    );

    @Test
    public void testFind() {
        PostFinder postFinder = new PostFinder(testData);
        System.out.println(postFinder.findPost("Pista"));

    }

    @Test
    public void testFind2() {
        PostFinder2 postFinder2 = new PostFinder2(testData);
        System.out.println(postFinder2.findPosts("Pista"));

    }
}
