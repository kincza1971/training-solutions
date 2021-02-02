package collectionscomp;


public class Konyv implements Comparable<Konyv>{
    private final int regNumber;
    private final String title;
    private final String author;

    public Konyv(int regNumber, String author, String title) {
        this.regNumber = regNumber;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "" + regNumber + " " + author + " " + title;
    }

    @Override
    public int compareTo(Konyv o) {
        return Integer.compare(this.getId(), o.getId());
    }

    @Override
    public int hashCode() {
        return regNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Konyv konyv = (Konyv) o;
        return regNumber == konyv.regNumber;
    }
}
