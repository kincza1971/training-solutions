package week05.d05;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private List<Song> songList = new ArrayList<>();

    private boolean isSongLonger(Song song, int mins) {
        return (song.getLengthInSeconds()/(mins*60 +1) >=1);
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        if (songList.size()<1) {
            throw new NullPointerException("A számok listája üres");
        }
        List<Song> longerList = new ArrayList<>();
        for (Song song : songList) {
            if (isSongLonger(song, mins)) {
                longerList.add(song);
            }
        }
        return longerList;
    }

    public PlayList(List<Song> songList) {
        this.songList = songList;
    }
}
