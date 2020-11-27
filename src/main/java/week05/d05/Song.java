package week05.d05;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    private boolean isEmpty(String toCheck) {
        return (toCheck == null || toCheck.isBlank());
    }

    @Override
    public String toString() {
        return String.format("Title: %s artist: %s length in seconds: %d\n", name,artist,lengthInSeconds);
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("A szám címe: (" + name + ") nem megfelelő");
        }
        if (isEmpty(artist)) {
            throw new IllegalArgumentException("A előadó neve: (" + name + ") nem megfelelő");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }
}
