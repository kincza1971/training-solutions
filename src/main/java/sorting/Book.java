package sorting;


public class Book implements Comparable<Book>{
    private final int regNumber;
    private final String title;
    private final String author;

    public Book(int regNumber, String author, String title) {
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
    public int compareTo(Book o) {
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
        Book book = (Book) o;
        return regNumber == book.regNumber;
    }
}
