package week13.d03;

public class Book {
    private final String author;
    private final String title;
    private final int numberOfPage;

    public Book(String author, String title, int numberOfPage) {
        this.author = author;
        this.title = title;
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }
}
