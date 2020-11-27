package week05.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistTest {

    Song s1 = new Song("Take me to the river", 213, "unknown");
    Song s2 = new Song("Yellow submarine", 90, "Beatles");
    Song s3 = new Song("It's a yeah yeah", 100, "Matt Bianko");
    Song s4 = new Song("Fekete lakkcipő", 180, "Komár László");
    Song s5 = new Song("House os the raising Sun", 200, "Anyám kedvence");

    List<Song> songList = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5));

    @Test
    public void findTest() {
        Assertions.assertEquals( 2, new PlayList(songList).findByLengthGreaterThan(3).size());
        Assertions.assertEquals( 3, new PlayList(songList).findByLengthGreaterThan(2).size());
    }

    @Test
    public void PrintTest() {
        System.out.println(songList.toString());
    }
}
